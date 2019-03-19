/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2005-2017 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
(function () {

"use strict";

var ui = angular.module("axelor.ui");

ui.ViewCtrl = ViewCtrl;
ui.ViewCtrl.$inject = ['$scope', 'DataSource', 'ViewService'];

function ViewCtrl($scope, DataSource, ViewService) {

	$scope._viewParams = $scope._viewParams || $scope.selectedTab;
	if (!$scope._viewParams) {
		throw "View parameters are not provided.";
	}

	var params = $scope._viewParams;

	$scope._views = ViewService.accept(params);
	$scope._viewType = params.viewType;

	if ($scope.$parent && $scope.$parent._model) {
		$scope._parentModel = $scope.$parent._model;
	}

	$scope._model = params.model;
	$scope._fields = {};

	$scope._dataSource = null;
	$scope._domain = params.domain;
	$scope._context = params.context;
	
	if (params.model) {
		$scope._dataSource = DataSource.create(params.model, params);
	}
	
	$scope._defer = function() {
		return ViewService.defer();
	};

	$scope.loadView = function(viewType, viewName) {
		var view = $scope._views[viewType] || {
			type: viewType,
			name: viewName
		};
		var ctx = $scope._context;
		if ($scope.getContext) {
			ctx = $scope.getContext();
		}
		return ViewService.getMetaDef($scope._model, view, ctx);
	};

	$scope.loadFields = function() {
		return ViewService.getFields($scope._model);
	};
	
	$scope.updateRoute = function() {
		this.$emit("on:update-route");
	};

	$scope.getRouteOptions = function() {
		throw "Not Implemented.";
	};
	
	$scope.setRouteOptions = function(options) {
		throw "Not Implemented.";
	};
	
	var switchedTo = null;

	$scope.switchTo = function(viewType, /* optional */ callback) {

		var view = $scope._views[viewType];
		if (!view) {
			return;
		}
		
		var promise = view.deferred.promise;
		promise.then(function(viewScope){

			if (!viewScope || switchedTo === viewType) {
				return;
			}
			
			switchedTo = viewType;

			$scope._viewTypeLast = $scope._viewType === 'form' ? $scope._viewTypeLast : $scope._viewType;
			$scope._viewType = viewType;
			$scope._viewParams.viewType = viewType; //XXX: remove
			$scope._viewParams.$viewScope = viewScope;
			
			viewScope.show();
			
			if (viewScope.updateRoute) {
				viewScope.updateRoute();
			}

			if (callback) {
				callback(viewScope);
			}
		});
	};
	
	if (!params.action) {
		return;
	}
	
	// hide toolbar button titles
	$scope.tbTitleHide = !axelor.config['view.toolbar.titles'];

	function switchAndEdit(id, readonly) {
		$scope.switchTo('form', function(scope) {
			scope._viewPromise.then(function() {
				scope.doRead(id).success(function(record) {
					scope.edit(record);
					scope.setEditable(!readonly);
				});
			});
		});
	}

	// show single or default record if specified
	var context = params.context || {};
	if (context._showSingle || context._showRecord) {
		var ds = $scope._dataSource;
		var forceEdit = (params.params||{}).forceEdit === true;

		if (context._showRecord > 0) {
			params.viewType = "form";
			return $scope.switchTo('form');
		}

		return ds.search({
			offset: 0,
			limit: 2,
			fields: ["id"]
		}).success(function(records, page){
			if (page.total === 1 && records.length === 1) {
				return switchAndEdit(records[0].id, !forceEdit);
			}
			return $scope.switchTo($scope._viewType || 'grid');
		});
	}
	
	// switch to the the current viewType
	$scope.switchTo($scope._viewType || 'grid');
}

/**
 * Base controller for DataSource views. This controller should not be used
 * directly but actual controller should inherit from it.
 * 
 */
ui.DSViewCtrl = function DSViewCtrl(type, $scope, $element) {

	if (!type) {
		throw "No view type provided.";
	}
	if (!$scope._dataSource) {
		throw "DataSource is not provided.";
	}
	
	$scope._viewResolver = $scope._defer();
	$scope._viewPromise = $scope._viewResolver.promise;
	
	var ds = $scope._dataSource;
	var view = $scope._views[type] || {};
	var viewPromise = null;
	var hiddenButtons = {};
	
	var params = $scope._viewParams;
	
	if (params.params && params.params.limit) {
		if (ds && ds._page) {
			ds._page.limit = +(params.params.limit) || ds._page.limit;
		}
	}

	$scope.fields = {};
	$scope.fields_related = {};
	$scope.schema = null;

	$scope.show = function() {
		if (!viewPromise) {
			viewPromise = $scope.loadView(type, view.name);
			viewPromise.then(function(meta){
				var schema = meta.view;
				var fields = meta.fields || params.fields;
				var toolbar = [];
				_.each(schema.toolbar, function(button){
					button.custom = true;
					if (/^(new|edit|save|delete|copy|cancel|back|refresh|search|export|log|files)$/.test(button.name)) {
						hiddenButtons[button.name] = button;
						button.custom = false;
					}
					toolbar.push(button);
				});
				var forceTitle = params.forceTitle;
				if (forceTitle === undefined) {
					forceTitle = (params.params||{}).forceTitle;
				}
				if (!forceTitle && schema.title) {
					$scope.viewTitle = schema.title;
				}
				$scope.fields = fields;
				$scope.fields_related = meta.related;
				$scope.schema = schema;
				$scope.toolbar = toolbar;
				$scope.menubar = schema.menubar;

				$scope.toolbarAsMenu = _.isEmpty(toolbar) ? null : [{
					icon: 'fa-wrench',
					isButton: true,
					items: _.map(toolbar, function (item) {
						return _.extend({}, item, {
							name: item.name,
							action: item.onClick,
							title: item.title || item.autoTitle || item.name
						});
					})
				}];

				// watch on view.loaded to improve performance
				schema.loaded = true;
			});
		}
		
		$scope.onShow(viewPromise);
	};
	
	$scope.onShow = function(promise) {
		
	};

	$scope.canNext = function() {
		return ds && ds.canNext();
	};

	$scope.canPrev = function() {
		return ds && ds.canPrev();
	};
	
	$scope.getPageSize = function() {
		var page = ds && ds._page;
		if (page) {
			return page.limit;
		}
		return 40;
	};

	$scope.setPageSize = function(value) {
		var page = ds && ds._page,
			limit = Math.max(0, +value) || 40;
		if (page && page.limit != limit) {
			page.limit = limit;
			$scope.onRefresh();
		}
	};
	
	var can = (function (scope) {
		var fn = null;
		var perms = {
			'new': 'create',
			'copy': 'create',
			'edit': 'write',
			'save': 'write',
			'delete': 'remove',
			'archive': 'remove',
			'export': 'export'
		};
		var actions = {
			'new': 'canNew',
			'edit': 'canEdit',
			'save': 'canSave',
			'copy': 'canCopy',
			'delete': 'canDelete',
			'archive': 'canArchive',
			'attach': 'canAttach'
		};

		function attr(which) {
			if (fn === null && _.isFunction(scope.attr)) {
				fn = scope.attr;
			}
			return !fn || fn(which) !== false;
		}
		
		function perm(which) {
			return which === undefined || scope.hasPermission(which);
		}
		
		return function can(what) {
			return attr(actions[what]) && perm(perms[what]);
		};
	})($scope);
	
	$scope.hasButton = function(name) {
		if (!can(name)) {
			return false;
		}
		if (_(hiddenButtons).has(name)) {
			var button = hiddenButtons[name];
			if (button.isHidden) {
				return !button.isHidden();
			}
			return !button.hidden;
		}
		return true;
	};
	
	$scope.hasPermission = function(perm) {
		var view = $scope.schema;
		var defaultValue = arguments.length === 2 ? arguments[1] : true;
		if (!view || !view.perms) return defaultValue;
		var perms = view.perms;
		var permitted = perms[perm];
		if (permitted === undefined) {
			return defaultValue;
		}
		return _.toBoolean(permitted);
	};

	$scope.isPermitted = function(perm, record, callback) {
		var ds = this._dataSource;
		ds.isPermitted(perm, record).success(function(res){
			var errors = res.errors;
			if (errors) {
				return axelor.dialogs.error(errors.read);
			}
			callback();
		});
	};
	
	$scope.canShowToolbar = function() {
		var params = ($scope._viewParams || {}).params;
		if (params && params['show-toolbar'] === false) {
			return false;
		}
		return true;
	};

	$scope.hasHelp = function() {
		var view = $scope.schema;
		return view ? view.helpLink : false;
	};

	$scope.onShowHelp = function() {
		if ($scope.hasHelp()) {
			window.open($scope.schema.helpLink);			
		}
	};

	if (view.deferred) {
		view.deferred.resolve($scope);
	}

	$scope.$on('on:tab-reload', function(e, tab) {
		if ($scope === e.targetScope && $scope.onRefresh) {
			$scope.onRefresh();
		}
	});
};

ui.directive('uiViewPane', function() {

	return {
		replace: true,
		controller: ['$scope', '$attrs', 'DataSource', 'ViewService', function ($scope, $attrs, DataSource, ViewService) {
			
			var params = $scope.$eval($attrs.uiViewPane);
			
			$scope._viewParams = params;
			ViewCtrl.call(this, $scope, DataSource, ViewService);
			
			$scope.viewList = [];
			$scope.viewType = null;

			var switchTo = $scope.switchTo;
			$scope.switchTo = function (type, callback) {
				var view = $scope._views[type];
				if (view && $scope.viewList.indexOf(type) === -1) {
					$scope.viewList.push(type);
				}
				$scope.viewType = type;
				return switchTo(type, callback);
			};
			
			$scope.$watch('selectedTab.viewType', function viewTypeWatch(type) {
				var params = $scope._viewParams;
				if (params && params.$viewScope !== $scope.selectedTab.$viewScope) {
					return;
				}
				if ($scope.viewType !== type && type) {
					$scope.switchTo(type);
				}
			});

			$scope.viewTemplate = function (type) {
				var tname = "ui-template:" + type;
				var template = type;
				if (params.params && params.params[tname]) {
					template = params.params[tname];
				}
				return 'partials/views/' + template + '.html';
			};

			var type = params.viewType || params.type;
			$scope.keepAttached = $scope._isPopup || (params.params||{}).popup || type === 'html';
			$scope.switchTo(type);
		}],
		link: function(scope, element, attrs) {
		
		},
		template:
			"<div class='view-pane' ui-attach='keepAttached || tab.selected'>" +
				"<div class='view-container'" +
				" ng-repeat='type in viewList'" +
				" ui-show='type === viewType'" +
				" ui-attach-scroll ui-attach='keepAttached || type == viewType'" +
				" ng-include='viewTemplate(type)'></div>" +
			"</div>"
	};
});

ui.directive('uiViewPopup', function() {
	
	return {
		controller: ['$scope', '$element', '$attrs', function ($scope, $element, $attrs) {
			var params = $scope.$eval($attrs.uiViewPopup);

			$scope.tab = params;
			$scope._isPopup = true;

			$scope.onHotKey = function (e, action) {
				return false;
			};

			var canClose = false;

			$scope.onOK = function () {
				$scope.closeTab($scope.tab, function() {
					canClose = true;
					$element.dialog('close');
				});
			};
			
			$scope.onBeforeClose = function(e) {
				if (canClose) {
					return;
				}
				e.preventDefault();
				e.stopPropagation();
				$scope.onOK();
			};

			$scope.onPopupClose = function () {
				var tab = $scope.tab,
					params = tab.params || {},
					parent = tab.$popupParent;

				while (parent && parent.$$destroyed && parent.tab) {
					parent = parent.tab.$popupParent;
				}
				if (parent && parent.reload && params.popup === "reload") {
					parent.reload();
				}
				$scope.$applyAsync();
			};

			$scope.onPopupOK = function () {
				var viewScope = $scope._viewParams.$viewScope;
				if (!viewScope.onSave || (!viewScope.isDirty() && viewScope.id)) {
					return $scope.onOK();
				}
				return viewScope.onSave({ fireOnLoad: false }).then(function(record, page) {
					viewScope.edit(record);
					viewScope.$timeout($scope.onOK.bind($scope));
				});
			};

			params = $scope.tab.params || {};
			if (params['popup-save'] === false) {
				$scope.onPopupOK = false;
			}
		}],
		link: function (scope, element, attrs) {

			scope.$watch('viewTitle', function viewTitleWatch(title) {
				scope._setTitle(title);
			});

			scope.waitForActions(function () {
				if (scope._viewParams.viewType === 'html') {
					scope.viewTitle = scope.tabTitle(scope._viewParams);
					scope._doShow();
					return;
				}
				
				var unwatch = scope.$watch("_viewParams.$viewScope.schema.loaded", function viewLoadedWatch(loaded) {
					if (!loaded) {
						return;
					}
					unwatch();
					var viewScope = scope._viewParams.$viewScope;
					var viewPromise = viewScope._viewPromise;
					scope.viewTitle = scope.tabTitle(scope._viewParams);
					scope._doShow(viewPromise);
				});
			});
		},
		replace: true,
		template:
			'<div ui-dialog ui-dialog-size x-resizable="true" x-on-close="onPopupClose" x-on-ok="onPopupOK" x-on-before-close="onBeforeClose">' +
				'<div ui-view-pane="tab"></div>' +
			'</div>'
	};
});

ui.directive('uiRecordPager', function(){

	return {
		replace: true,
		link: function(scope, element, attrs) {
			
			var elText = element.find('.record-pager-text').show(),
				elChanger = element.find('.record-pager-change').hide(),
				elInput = elChanger.find('input');
			
			scope.showText = attrs.uiRecordPager !== "no-text";
			
			function updatePageSize() {
				var size = +(elInput.val()) || 0;
				if (scope.setPageSize && size > 0) {
					scope.setPageSize(size);
				}
				elText.add(elChanger).toggle();
			}

			elText.click(function(e) {
				elText.add(elChanger).toggle();
				elInput.zIndex(elInput.parent().zIndex() + 1).focus().select();
			});

			elInput.on('click', function () {
				elInput.zIndex(elInput.parent().zIndex() + 1).focus().select();
			});

			elChanger.on('click', 'button',  function() {
				updatePageSize();
			});

			elChanger.keyup(function(e) {
				if(e.keyCode == 13) { // ENTER
					updatePageSize();
			    }
			});

		},
		template:
		'<div class="record-pager hidden-phone">'+
	    '<span ng-show="showText">'+
	    	'<span class="record-pager-text">{{pagerText()}}</span>'+
			'<span class="input-append record-pager-change">'+
				'<input type="text" style="width: 30px;" value="{{getPageSize()}}">'+
				'<button type="button" class="btn add-on"><i class="fa fa-check"></i></button>'+
			'</span>'+
	    '</span>'+
	    '<div class="btn-group">'+
	    	'<button class="btn" ng-disabled="!canPrev()" ng-click="onPrev()"><i class="fa fa-chevron-left"></i></button>'+
	    	'<button class="btn" ng-disabled="!canNext()" ng-click="onNext()"><i class="fa fa-chevron-right"></i></button>'+
	    '</div>'+
	    '</div>'
	};
});

ui.directive('uiViewCustomize', ['NavService', function(NavService) {

	return {
		scope: true,
		link: function (scope, element, attrs) {

			scope.canShow = function () {
				if (!axelor.config['user.technical']) {
					return false;
				}
				var viewScope = scope.selectedTab.$viewScope;
				var view = viewScope && viewScope.schema;
				return view && (view.viewId || view.modelId);
			};

			scope.hasViewID = function () {
				var viewScope = scope.selectedTab.$viewScope;
				var view = viewScope && viewScope.schema;
				return view && view.viewId;
			};

			scope.hasModelID = function () {
				var viewScope = scope.selectedTab.$viewScope;
				var view = viewScope && viewScope.schema;
				return view && view.modelId;
			}
			
			scope.hasActionID = function () {
				return scope.selectedTab.actionId;
			}

			scope.onShowView = function () {
				var id = scope.hasViewID();
				NavService.openTabByName("form::com.axelor.meta.db.MetaView", {
					mode: "edit",
					state: id
				});
				scope.waitForActions(function () {
					var vs = scope.selectedTab.$viewScope;
					if (vs && vs.setEditable) {
						vs.setEditable();
					}
				});
			}

			scope.onShowModel = function () {
				var id = scope.hasModelID();
				NavService.openTabByName("form::com.axelor.meta.db.MetaModel", {
					mode: "edit",
					state: id
				});
			}
			
			scope.onShowAction = function () {
				var id = scope.hasActionID();
				NavService.openTabByName("form::com.axelor.meta.db.MetaAction", {
					mode: "edit",
					state: id
				});
			}
		},
		replace: true,
		template:
			"<ul ng-show='canShow()' class='nav menu-bar view-customize hidden-phone'>" +
				"<li class='dropdown menu'>" +
					"<a class='dropdown-toggle btn' data-toggle='dropdown' title='{{ \"Customize...\" | t}}'>" +
						"<i class='fa fa-wrench'></i>" +
					"</a>" +
					"<ul class='dropdown-menu pull-right'>" +
						"<li><a ng-click='onShowView()' ng-show='hasViewID()'>View...</a></li>" +
						"<li><a ng-click='onShowModel()' ng-show='hasModelID()'>Model...</a></li>" +
						"<li><a ng-click='onShowAction()' ng-show='hasActionID()'>Action...</a></li>" +
					"</ul>" +
				"</li>" +
			"</ul>"
	};
}]);

function viewSwitcher(scope, element, attrs) {

	var params = (scope._viewParams || scope.tab);
	var viewTypes = _.pluck(params.views, 'type');

	if ((params.viewType || params.type) === 'dashboard') {
		element.hide();
		return;
	}

	element.find("[x-view-type]").click(function(e) {
		if (this.disabled) {
			return;
		}
		var type = $(this).attr("x-view-type");
		var vs = params.$viewScope || scope.selectedTab.$viewScope;
		var ds = vs._dataSource;
		var page = ds && ds._page;

		if (type === "form" && page) {
			if (page.index === -1) page.index = 0;
		}

		if (scope.selectedTab.viewType === 'grid') {
			var items = vs.getItems() || [];
			var index = _.first(vs.selection || []);
			if (index === undefined && items.length === 0 && vs.schema.canNew === false) {
				return;
			}
			if (index !== undefined) page.index = index;
		}

		vs.switchTo(type);
		vs.$applyAsync();
	}).each(function() {
		var type = $(this).attr("x-view-type");
		if (viewTypes.indexOf(type) === -1) {
			$(this).hide();
		}
	});

	var watchExpr = scope._viewParams ? '_viewType' : 'tab.viewType';
	scope.$watch(watchExpr, function viewTypeWatch(type) {
		element.find("[x-view-type]").attr("disabled", false);
		element.find("[x-view-type][x-view-type=" + type + "]").attr("disabled", true);
	});
}

ui.directive('uiViewSwitcher', function(){
	return {
		scope: true,
		link: function(scope, element, attrs) {
			element.parents('.view-container:first').addClass('has-toolbar');
			viewSwitcher(scope, element, attrs);
		},
		replace: true,
		template:
		'<div class="view-switcher pull-right hidden-phone">'+
		  	'<div class="btn-group">'+
		  		'<button class="btn" x-view-type="grid"><i class="fa fa-list"></i></button>'+
				'<button class="btn" x-view-type="cards"><i class="fa fa-th-large"></i></button>'+
				'<button class="btn" x-view-type="kanban"><i class="fa fa-columns"></i></button>'+
		  		'<button class="btn" x-view-type="calendar"><i class="fa fa-calendar"></i></button>'+
		  		'<button class="btn" x-view-type="gantt"><i class="fa fa-tasks"></i></button>'+
		  		'<button class="btn" x-view-type="chart"><i class="fa fa-bar-chart-o"></i></button>'+
		  		'<button class="btn" x-view-type="form"	><i class="fa fa-file-text-o"></i></button>'+
		    '</div>'+
		'</div>'
	};
});

ui.directive('uiViewSwitcherMenu', function(){
	return {
		scope: true,
		link: function(scope, element, attrs) {
			viewSwitcher(scope, element, attrs);
		},
		replace: true,
		template:
			"<span class='view-switch-menu dropdown pull-right'>" +
				"<a href='' class='dropdown-toggle' data-toggle='dropdown'><i class='fa fa-ellipsis-v'></i></a>" +
				"<ul class='dropdown-menu'>" +
				   "<li><a href='' x-view-type='grid' x-translate>Grid</a></li>" +
				   "<li><a href='' x-view-type='cards' x-translate>Cards</a></li>" +
				   "<li><a href='' x-view-type='kanban' x-translate>Kanban</a></li>" +
				   "<li><a href='' x-view-type='calendar' x-translate>Calendar</a></li>" +
				   "<li><a href='' x-view-type='gantt' x-translate>Gantt</a></li>" +
				   "<li><a href='' x-view-type='chart' x-translate>Chart</a></li>" +
				   "<li><a href='' x-view-type='form' x-translate>Form</a></li>" +
				"</ul>" +
			"</span>"
	};
});

ui.directive('uiHotKeys', function() {

	var keys = {
		45: 'new',		// insert
		69: 'edit',		// e
		83: 'save',		// s
		68: 'delete',	// d
		82: 'refresh',	// r
		70: 'search',	// f
		71: 'select',	// g
		74: 'prev',		// j
		75:	'next',		// n

		77: 'focus-menu',		// m
	   120: 'toggle-menu',		// F9

		81: 'close'		// q
	};
	
	return function(scope, element, attrs) {
		
		var loginWindow = $("#loginWindow");
		
		$(document).on('keydown.axelor-keys', function (e) {
			
			if (loginWindow.is(":visible")) {
				return;
			}
			
			// disable backspace as back button
			if (e.which === 8 && e.target === document.body) {
				e.preventDefault();
				return false;
			}

			var action = keys[e.which];
			
			if (action === "toggle-menu") {
				$('#offcanvas-toggle a').click();
				return false;
			}
			
			if (e.altKey || e.shiftKey || !e.ctrlKey) {
				return;
			}

			if (action === "focus-menu") {
				var activeMenu = $('.sidebar .nav-tree li.active');
				if (activeMenu.length === 0) {
					activeMenu = $('.sidebar .nav-tree li:first');
				}
				
				var navTree = activeMenu.parents('[nav-tree]:first');
				if (navTree.length) {
					navTree.navtree('selectItem', activeMenu);
				}
				return false;
			}
			
			var tab = scope.selectedTab,
				dlg = $('[ui-editor-popup]:visible:last,[ui-view-popup]:visible:last,[ui-dms-popup]:visible:last').first(),
				vs = tab ? tab.$viewScope : null;

			if (dlg.length) {
				vs = dlg.scope();
			}
			
			if (!vs || !keys.hasOwnProperty(e.which)) {
				return;
			}

			if (action === "close") {
				scope.closeTab(tab, function() {
					scope.$applyAsync();
				});
				return false;
			}
			
			if (action === "search") {
				var filterBox = $('.filter-box .search-query:visible');
				if (filterBox.length) {
					filterBox.focus().select();
					return false;
				}
			}
			
			if (_.isFunction(vs.onHotKey)) {
				return vs.onHotKey(e, action);
			}
		});

		scope.$on('$destroy', function() {
			$(document).off('keydown.axelor-keys');
		});
	};
});

})();
