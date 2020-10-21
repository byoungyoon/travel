package travel.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import travel.dao.StatsDao;
import travel.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener {
	private StatsService stateService;
	
	public StatsListener() {}

    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("세션값 확인");
         if(se.getSession().isNew()) {
        	 stateService = new StatsService(new StatsDao());
        	 stateService.countStats();
         }
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { }
}
