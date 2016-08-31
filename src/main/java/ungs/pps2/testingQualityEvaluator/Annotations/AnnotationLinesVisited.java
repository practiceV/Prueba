package ungs.pps2.testingQualityEvaluator.Annotations;

import java.lang.annotation.ElementType; 
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) 
public @interface  AnnotationLinesVisited{ 
	int position(); 
	String testClass(); 
}
