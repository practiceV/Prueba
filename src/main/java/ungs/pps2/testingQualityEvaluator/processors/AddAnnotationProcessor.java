package ungs.pps2.testingQualityEvaluator.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement; 
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod; 

public class AddAnnotationProcessor extends AbstractProcessor<CtElement> { 

	public void process(CtElement element) {
		CtCodeSnippetStatement snippet = element.getFactory().Core().createCodeSnippetStatement(); 
		final String value = String.format("@Linea %s ejecutada desde el test %s", 
				element.getPosition().getLine(), 
				element.getParent(CtClass.class).getSimpleName()); 
		snippet.setValue(value); 
		// Inserts the snippet at the beginning of the method body.
		element.getPosition();
		CtMethod<?> method = element.getParent(CtMethod.class);
        CtBlock<?> body = method.getBody();

		if (body != null) { 
			body.insertBegin(snippet); 
		} 
	}
} 
