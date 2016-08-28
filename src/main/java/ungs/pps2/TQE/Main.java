package ungs.pps2.TQE;

import java.util.List;

import spoon.Launcher;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.filter.TypeFilter;
import ungs.pps2.TQE.processors.Processor_BinaryOperator;

public class Main {

	public static void main(String[] args) {
		Launcher spoon=new Launcher();
		spoon.addInputResource("src/main/java/ungs/pps2/TQE/resources/Ejemplo.java");
	    spoon.setSourceOutputDirectory("src/main/java/ungs/pps2/TQE/Spooned");
	    spoon.run();
		Processor_BinaryOperator processor = new Processor_BinaryOperator();
	    List<CtElement> elements=spoon.getModel().getElements(new TypeFilter(CtBinaryOperator.class));
	    int indice=1;
	    for(CtElement element: elements){
	    	CtElement elementAux=element.clone();
	    	processor.process(element);
		    spoon.setSourceOutputDirectory("src/main/java/ungs/pps2/TQE/Spooned/MutantNumber"+indice+"/");
		    spoon.prettyprint();
		    element.replace(elementAux);
		    indice++;
	    }
	}

}
