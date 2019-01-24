import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//@ApplicationPath("/app")
public class ArticleApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	
	public ArticleApplication() {
        singletons.add(new ArticleService());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
