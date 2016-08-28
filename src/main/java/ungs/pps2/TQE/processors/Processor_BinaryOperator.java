package ungs.pps2.TQE.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;

public class Processor_BinaryOperator extends AbstractProcessor{
	@Override
	public boolean isToBeProcessed(CtElement candidate) {
		return candidate instanceof CtBinaryOperator;
	}

	public void process(CtElement candidate) {
		if (!(candidate instanceof CtBinaryOperator)) {
			return;
		}
		CtBinaryOperator op = (CtBinaryOperator)candidate;
		if (BinaryOperatorKind.PLUS.equals(op.getKind())) {
			op.setKind(BinaryOperatorKind.MUL);
		}
	}
}
