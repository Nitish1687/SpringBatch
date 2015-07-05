import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nitish Shukla on 04-07-2015.
 */
public class SimpleJob {

    public static void main(String[] args)  {
        ClassPathXmlApplicationContext appContext = null;
        try {

            appContext = new ClassPathXmlApplicationContext("applicationBatchContext.xml");

            // get the launcher
            JobLauncher jobLauncher = (JobLauncher) appContext.getBean("jobLauncher");
            // get the job to run
            Job job = (Job) appContext.getBean("simpleJob");
            // run
            jobLauncher.run(job, new JobParameters());

        }catch (Exception e){
            System.out.println(e.getCause()+"---------------"+e.getMessage());
        }
        finally {
            appContext.close();
        }
    }
}
