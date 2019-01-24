import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

@Path("/article")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)

public class ArticleService {
	List<Article> list = new ArrayList<Article>();
	{
		list.add(new Article("AAA","Hibernate"));
		list.add(new Article("xyz","English"));
    }
	
	@GET
	@Path("/fake")
	public void fake() {
		System.out.println("Executed");
	}
	
	@Path("/getArticles")
	@AddLinks
	@LinkResource(value = Article.class)
	@GET
	
	public Collection<Article> getArticles() {
		return list;
	}
	
	@POST
	@AddLinks
	@LinkResource
    @Path("/aadArticle")
    public void addArticle(Article article){
       list.add(article);	
    }
	
	@AddLinks
    @LinkResource
    @GET
    @Path("/article/{id}")
    public Article getArticle(@PathParam("id") Integer id) {
    	return list.get(id);
    }
	
	@AddLinks
	@LinkResource(value = Article.class)
	@GET
	@Path("/add")
	@Produces(MediaType.APPLICATION_XML)
	public Collection<Article> add(@MatrixParam("author") String author, @MatrixParam("title") String title) {
		list.add(new Article(author,title));
//		return "Successfully added" + author + title;
		return list;
	}
}
