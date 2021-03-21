package ds.students;

import ds.students.Token.Type;

/**
 * @author simont
 * @author traqy014
 */
public class Calculator {

	public DSQueue infixToPostfix(DSQueue infix) {
		DSQueue q = new DSQueue();
		DSStack operatorStack = new DSStack();
		while (!infix.isEmpty()) { //while there are tokens to be read
			Token p = infix.peek();
			if (p.type == Type.OPERAND) {
				q.offer(infix.poll());
			}
			else if (p.type == Type.OPERATOR) {
				if (!operatorStack.isEmpty()) {
					Token o2 = operatorStack.peek();
					if (p.getPrecedence() < o2.getPrecedence()|| p.getPrecedence() == o2.getPrecedence()) {
						q.offer(operatorStack.pop());
					}
					else {
						operatorStack.push(infix.poll());
					}
				}
				else {
					operatorStack.push(infix.poll());
				}	
			}
			else if (p.getOperator().equals("(")) {
				operatorStack.push(infix.poll());
			}
			else if (p.getOperator().equals(")")) {
				while (!operatorStack.isEmpty() && !operatorStack.peek().getOperator().equals("(") ) {
					q.offer(operatorStack.pop());
				}
				if (operatorStack.isEmpty()) {
					throw new RuntimeException("Unmatched opening parenthesis");
				}
				else {
					operatorStack.pop();
					infix.poll();
				}
			}
		}
		  //while there are no more tokens to be read
			while (!operatorStack.isEmpty()) {
				if (operatorStack.peek().type == Type.PAREN) {
					throw new RuntimeException("Unmatched opening parenthesis");
				}
				else {
					q.offer(operatorStack.pop());
				}
			}
		
		return q;
	}

	
	public double evaluatePostfix(DSQueue exp){
		DSStack s = new DSStack();
		while (!exp.isEmpty()) {
			if (exp.peek().type == Type.OPERAND) {
				s.push(exp.poll());
			}
			else if (exp.peek().type == Type.OPERATOR) {
				double E2 = s.pop().getOperand();
				double E1 = s.pop().getOperand();
				double result = 0;
				Token O1 = exp.poll();
				switch(O1.getOperator()) {
				case "+": result = E1 + E2;
				          break;
				case "-": result = E1 - E2;
				          break;
				case "/": result = E1 / E2;
				          break;
				case "*": result = E1 * E2;
				          break;
				
				}
				s.push(new Token(result));
			}
		}
		
		if (s.size() >1) {
			throw new RuntimeException();
		}
		return s.peek().getOperand();
		
	}
}
