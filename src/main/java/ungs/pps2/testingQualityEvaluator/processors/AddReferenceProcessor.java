package ungs.pps2.testingQualityEvaluator.processors;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtThrow;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import ungs.pps2.testingQualityEvaluator.Annotations.AnnotationLinesVisited;
 
/** 
  * we only process method parameters (CtParameter) annotated with @AnnotationLinesVisited 
  * 
  * @author petitpre 
  */ 
 public class AddReferenceProcessor extends AbstractAnnotationProcessor<AnnotationLinesVisited, CtParameter<?>> { 
 	public void process(AnnotationLinesVisited annotation, CtParameter<?> element) { 
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
		/*
 		final CtMethod parent = element.getParent(CtMethod.class); 
  
 		CtIf anIf = getFactory().Core().createIf(); 
 		anIf.setCondition(getFactory().Code().<Boolean>createCodeSnippetExpression(element.getPosition().getLine() + " < " + annotation.position())); 
 		CtThrow throwStmt = getFactory().Core().createThrow(); 
 		throwStmt.setThrownExpression((CtExpression<? extends Throwable>) getFactory().Core().createCodeSnippetExpression().setValue("new RuntimeException(\"out of min bound (\" + " + element.getSimpleName() + " + \" < " + annotation.position() + "\")")); 
 		anIf.setThenStatement(throwStmt); 
 		parent.getBody().insertBegin(anIf); 
 		anIf.setParent(parent); 
 		// Build if check for max. 

 		anIf = getFactory().Core().createIf(); 
 		anIf.setCondition(getFactory().Code().<Boolean>createCodeSnippetExpression(element.getSimpleName() + " > " + annotation.testClass())); 
 		anIf.setThenStatement(getFactory().Code().createCtThrow("new RuntimeException(\"out of max bound (\" + " + element.getSimpleName() + " + \" > " + annotation.testClass() + "\")")); 
 		parent.getBody().insertBegin(anIf); 
 		anIf.setParent(parent); */
 	} 
} 
