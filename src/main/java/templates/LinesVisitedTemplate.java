package templates;

import spoon.reflect.code.CtStatement; 
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtType; 
import spoon.reflect.reference.CtTypeReference; 
import spoon.template.AbstractTemplate; 
import spoon.template.Local; 
import spoon.template.Parameter; 
import spoon.template.Substitution;

public class LinesVisitedTemplate extends AbstractTemplate<CtStatement>{

	@Parameter 
	public CtTypeReference<?> typeReference; 

	@Parameter 
	public String _parameter_; 
 
 	@Parameter 
 	public CtElement _element_; 

	@Parameter 
 	public String _nameTest_;  
 
 	@Local 
 	public LinesVisitedTemplate(CtTypeReference<Double> typeReference, String parameterName, CtElement element, String nameTest) {
 		this.typeReference= typeReference;
 		_parameter_ = parameterName; 
 		_element_ = element; 
 		_nameTest_ = nameTest; 
 	} 
 
 	public CtStatement apply(CtType<?> targetType) { 
 		return Substitution.substituteStatement((CtClass) targetType, this, _element_.getPosition().getLine(), "test"); 
 	} 
 } 
