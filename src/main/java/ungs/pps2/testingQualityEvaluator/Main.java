package ungs.pps2.testingQualityEvaluator;

import java.util.List;

import spoon.Launcher;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.visitor.filter.TypeFilter;
import templates.LinesVisitedTemplate;
import ungs.pps2.testingQualityEvaluator.Annotations.AnnotationLinesVisited;
import ungs.pps2.testingQualityEvaluator.processors.AddAnnotationProcessor;
import ungs.pps2.testingQualityEvaluator.processors.AddReferenceProcessor;
import ungs.pps2.testingQualityEvaluator.processors.AddReferenceTemplateProcessor;
import ungs.pps2.testingQualityEvaluator.processors.Processor_BinaryOperator;

public class Main {

	public static void main(String[] args) {
		Launcher spoon=new Launcher();
		spoon.addInputResource("src/main/java/ungs/pps2/testingQualityEvaluator/resources/Ejemplo.java");
	    spoon.setSourceOutputDirectory("Spooned");
		Processor_BinaryOperator processor = new Processor_BinaryOperator();
		//AddReferenceProcessor processorAnnotation=new AddReferenceProcessor();
		AddAnnotationProcessor processorAnnotation1=new AddAnnotationProcessor();
	    spoon.run();
	    List<CtElement> elements=spoon.getModel().getElements(new TypeFilter(CtBinaryOperator.class));
	    int indice=1;
	    for(CtElement element: elements){
	    	CtElement elementAux=element.clone();
	    	processor.process(element);
	    	processorAnnotation1.process(element);

	    	if(!element.equals(elementAux)){
	    		spoon.setSourceOutputDirectory("Spooned/MutantNumber"+indice+"/");
	    		spoon.prettyprint();
	    		element.replace(elementAux);
	    		indice++;
	    	}
	    }
	}

}
