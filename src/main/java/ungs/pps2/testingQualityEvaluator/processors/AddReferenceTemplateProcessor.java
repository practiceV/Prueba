package ungs.pps2.testingQualityEvaluator.processors;
 
import spoon.processing.AbstractAnnotationProcessor; 
import spoon.reflect.code.CtBlock; 
import spoon.reflect.code.CtStatement; 
import spoon.reflect.declaration.CtClass; 
import spoon.reflect.declaration.CtExecutable; 
import spoon.reflect.declaration.CtParameter; 
import spoon.template.Template;
import templates.LinesVisitedTemplate;
import ungs.pps2.testingQualityEvaluator.Annotations.AnnotationLinesVisited; 
 
public class AddReferenceTemplateProcessor extends AbstractAnnotationProcessor<AnnotationLinesVisited, CtParameter<?>> {

public void process(AnnotationLinesVisited annotation, CtParameter<?> element) { 
	// Is to be process? 
	CtExecutable<?> e = element.getParent(); 
	if (e.getBody() == null) { 
		return; 
	} 
	
	// Use template. 
	CtClass<?> type = (CtClass<?>) e.getParent(CtClass.class); 
	Template t = new LinesVisitedTemplate(getFactory().Type().createReference(Double.class), element.getSimpleName(), element, annotation.testClass()); 
	final CtBlock apply = (CtBlock) t.apply(type); 
 
	// Apply transformation. 
	for (int i = apply.getStatements().size() - 1; i >= 0; i--) { 
		final CtStatement statement = apply.getStatement(i); 
		e.getBody().insertBegin(statement); 
		statement.setParent(e.getBody()); 
	} 
} 
} 
