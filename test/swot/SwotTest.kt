package swot

import kotlin.test.*
import junit.framework.*

class SwotTest : TestCase() {
    fun testSwot() {
        assertEquals (true , isAcademic("lreilly@stanford.edu"))          
        assertEquals (true , isAcademic("LREILLY@STANFORD.EDU"))          
        assertEquals (true , isAcademic("Lreilly@Stanford.Edu"))          
        assertEquals (true , isAcademic("lreilly@slac.stanford.edu"))     
        assertEquals (true , isAcademic("lreilly@strath.ac.uk"))          
        assertEquals (true , isAcademic("lreilly@soft-eng.strath.ac.uk")) 
        assertEquals (true , isAcademic("lee@ugr.es"))                    
        assertEquals (true , isAcademic("lee@uottawa.ca"))                
        assertEquals (true , isAcademic("lee@mother.edu.ru"))             
        assertEquals (true , isAcademic("lee@ucy.ac.cy"))                 
        assertEquals (false, isAcademic("lee@leerilly.net"))              
        assertEquals (false, isAcademic("lee@gmail.com"))                 
        assertEquals (false, isAcademic("lee@stanford.edu.com"))          
        assertEquals (false, isAcademic("lee@strath.ac.uk.com"))          
        assertEquals (true , isAcademic("stanford.edu"))                  
        assertEquals (true , isAcademic("slac.stanford.edu"))             
        assertEquals (true , isAcademic("www.stanford.edu"))              
        assertEquals (true , isAcademic("http://www.stanford.edu"))       
        assertEquals (true , isAcademic("http://www.stanford.edu:9393"))  
        assertEquals (true , isAcademic("strath.ac.uk"))                  
        assertEquals (true , isAcademic("soft-eng.strath.ac.uk"))         
        assertEquals (true , isAcademic("ugr.es"))                        
        assertEquals (true , isAcademic("uottawa.ca"))                    
        assertEquals (true , isAcademic("mother.edu.ru"))                 
        assertEquals (true , isAcademic("ucy.ac.cy"))                     
        assertEquals (false, isAcademic("leerilly.net"))                  
        assertEquals (false, isAcademic("gmail.com"))                     
        assertEquals (false, isAcademic("stanford.edu.com"))              
        assertEquals (false, isAcademic("strath.ac.uk.com"))              
        assertEquals (false, isAcademic(""))
        assertEquals (false, isAcademic("the"))                           
        assertEquals (true , isAcademic(" stanford.edu"))                 
        assertEquals (true , isAcademic("lee@strath.ac.uk "))             
        assertEquals (false, isAcademic(" gmail.com "))                   
        assertEquals (true , isAcademic("lee@stud.uni-corvinus.hu"))      
        assertEquals (true , isAcademic("lee@harvard.edu"))               
        assertEquals (true , isAcademic("lee@mail.harvard.edu"))

        assertEquals(false, isAcademic("imposter@si.edu"))

        // Iran sanctions are lifted
        assertEquals(true, isAcademic("lee@acmt.ac.ir"))
    }

    fun testSchoolNames() {
        assertEquals("University of Strathclyde", findSchoolNames("lreilly@cs.strath.ac.uk").single())
        assertEquals("BRG Fadingerstraße Linz, Austria", findSchoolNames("lreilly@fadi.at").single())
        assertEquals("St. Petersburg State University", findSchoolNames("max@spbu.ru ").single())
        assertEquals(0, findSchoolNames("foo@shop.com").size)
    }
}
