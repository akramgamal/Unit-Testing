package org.jfree.data.test;
import org.jfree.data.Range;
import org.junit.*;

public class Rangetest {
    static Range range;
    @BeforeClass
    public static void setUp(){
        range= new Range(1,8);
    }
    @Test
    public void containsTest(){
        boolean res=range.contains(1);
        boolean res2=range.contains(2);
        boolean res3=range.contains(4);
        boolean res4=range.contains(100);
        Assert.assertEquals(true,res);//wrong actual should be 1
        Assert.assertEquals(true,res2);
        Assert.assertEquals(true,res3);
        Assert.assertEquals(true,res4);
    }
    @Test
    public void  combineTest(){
        Range range1= new Range(1,6);
        Range range2= new Range(1,9);
        Range res=Range.combine(range1,range2);
        Assert.assertEquals(range,res); //wrong combine in the end with the lower value
    }
    @Test
    public void  constrainTest(){
       double res=range.constrain(10);
       Assert.assertEquals(9,res,0.0);//passed
        Assert.assertEquals(5,res,0.0);//fail
    }
    @Test
    public void  expandTest(){
        Range range1=new Range(2,6);
        Range res= Range.expand(range1,0.25, 0.5);
        Assert.assertEquals(range,res);//wrong increase fe el lower
    }
    @Test
     public void expandToIncludeTest(){
        Range range1=new Range(2,6);
        Range res= Range.expandToInclude(range1,9);
        Assert.assertEquals(range,res);//passed 2,9
     }

    @Test
     public void getCentralValueTest(){
        double res= range.getCentralValue();
        Assert.assertEquals(4,res,0);//fail
        Assert.assertEquals(4.5,res,0);//passed
     }
    @Test
     public void getLengthTest(){
        double res= range.getLength();
        Assert.assertEquals(4,res,0);//fail
        Assert.assertEquals(7,res,0);//passed
     }
     @Test
     public void getLowerBoundTest(){
       double res= range.getLowerBound();
       Assert.assertEquals(4,res,0);//fail
       Assert.assertEquals(1,res,0);//passed
     }
      @Test
      public void getUpperBoundTest(){
           double res= range.getUpperBound();
           Assert.assertEquals(4,res,0);//fail
           Assert.assertEquals(8,res,0);//passed
        }
       @Test
        public void intersectsTest(){
           boolean res= range.intersects(9,10);
           Assert.assertEquals(true,res);//wrong passed even if it's not intersect

        }
      @Test
      public void shiftTest(){
           Range range1=new Range(1,6);
           Range range2=new Range(3,8);
           Range res=Range.shift(range1,2);
           Assert.assertEquals(range,res);//fail
           Assert.assertEquals(range2,res);//passed
        }
     @Test
      public void shift2Test(){
           Range range1=new Range(-5,5);
           Range range2=new Range(-3,7);
           Range res=Range.shift(range1,2,true);
           Range res2=Range.shift(range1,2,false);
           Assert.assertEquals(range,res);//fail
           Assert.assertEquals(range,res2);//fail
           Assert.assertEquals(range2,res);//passed
        }
}
