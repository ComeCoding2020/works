package com.saksham.SpringAnnotationPractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       
        // when using bean.XML file use this code  
       // FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
        
        //when using java configuration file use this code
        ApplicationContext context= new AnnotationConfigApplicationContext(CollegeConfiguration.class);
        System.out.println("configuration file loaded");
        
        // With using XML use below code
        //TvRemote remote = (TvRemote) context.getBean("tvRemote");
        
        // for @Annotations use this
       //TvRemote remote = (TvRemote) context.getBean(TvRemote.class);
        
        //remote.performAction();
       
        College college = context.getBean("colBean", College.class);
        System.out.println("All methods works \t"+ college);
        college.test();
        
        ((AbstractApplicationContext) context).close();
    }
}
