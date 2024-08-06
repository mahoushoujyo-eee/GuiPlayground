package Calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.math.BigDecimal;





public class NewCalculator extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	private static TextField text;
	private static double value;
	private static String answer = "";
	private static String operation = "";

	@Override
	/* Override the start() method in Application class.*/
	public void start(Stage primaryStage)
	{
		Pane pane = layoutInit();

		String pattern = "[0-9]";

		// the layoutInit() is too redundant, so I write the keyboard processing here.
		pane.setOnKeyPressed(e ->
		{
			KeyCode key = e.getCode();
			if (key.isDigitKey())
			{
				String number = key.getName();
				number = number.substring(number.length() - 1, number.length());
				text.appendText(number);
			}
			else
			{
				String sign = key.getName();

				if (sign.equals("."))
				{

				}
				else
				{
					switch(key)
					{
					case ENTER: calculate(); break;
					case BACK_SPACE: backSpaceHandler(); break;
					case ADD: text.appendText("+"); break;
					case SUBTRACT: text.appendText("-"); break;
					case MULTIPLY: text.appendText("  "); break;
					case DIVIDE: text.appendText("  "); break;
					case ESCAPE: clearHandler(); break;
					case DECIMAL: addPoint(); break;
					default: System.out.println(key.getName()); break;
					}
				}
			}
		});

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();

		pane.requestFocus();
	}

	public static Pane layoutInit()
	{
		text = new TextField();
		text.setEditable(false);	// Prevent the case of reading non-arithmatic input
		text.setAlignment(Pos.CENTER_RIGHT);

		// Create a GridPane to hold buttons
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		// Create numeric buttons [1, 9], and then place them into gridPane
		LargeButton[] bts = new LargeButton[10];
		for (int i = 1; i < bts.length; i++)
		{
			String iString = new Integer(i).toString();							// Name of the button
			bts[i] = new LargeButton(iString);
			bts[i].setOnAction(e -> text.appendText(iString));	// Append the number to the end of text

			int j = i;
			if (j % 3 == 0)
				j = 2;
			else
				j = (i % 3) - 1;
			gridPane.add(bts[i], j, 2 - ((i - 1) / 3));
		}

		// Create buttons of operators and add them to the GridPane.
		LargeButton[] btOperators = new LargeButton[4];
		btOperators[0] = new LargeButton("+");
		btOperators[1] = new LargeButton("-");
		btOperators[2] = new LargeButton("  ");
		btOperators[3] = new LargeButton("  ");
		for (int i = 0; i < btOperators.length; i++)
			gridPane.add(btOperators[i], 3, i);

		// Create handler for operators.
		btOperators[0].setOnAction(e ->
		{
			// If there is an operator, then the length of the string must be more than 0.
			// So, there is no need to check the length.
			if (hasOperator() == false || hasOperator(operation.substring(1)) == false)
				text.appendText("+");
			else
				calculate("+");

		});

		btOperators[1].setOnAction(e ->
		{
			if (hasOperator() == false || hasOperator(operation.substring(1)) == false)
				text.appendText("-");
			else
				calculate("-");
		});

		btOperators[2].setOnAction(e ->
		{
			if (hasOperator() == false || hasOperator(operation.substring(1)) == false)
				text.appendText("  ");
			else
				calculate("  ");
		});

		btOperators[3].setOnAction(e ->
		{
			if (hasOperator() == false || hasOperator(operation.substring(1)) == false)
				text.appendText("  ");
			else
				calculate("  ");
		});

		// Buttons 0, +/-, .
		LargeButton bt0 = new LargeButton("0");
		LargeButton btOpposite = new LargeButton("+/-");
		LargeButton btPoint = new LargeButton(".");
		bt0.setOnAction(e -> text.appendText("0"));
		btOpposite.setOnAction(e ->
		{
			String content = text.getText();
			int flag = 0;
			if (content.length() > 0 && content.charAt(0) == '-')
			{
				flag = 1;
				content = content.substring(1);
			}

			if (hasOperator(content) == false && content.length() != 0)
			{
				value = Double.parseDouble(content);
				if (flag == 0)
					value = -value;

				answer = new BigDecimal(value).toPlainString();
				text.setText(answer);
			}
		});
		btPoint.setOnAction(e -> addPoint());
		gridPane.add(bt0, 0, 3);
		gridPane.add(btOpposite, 1, 3);
		gridPane.add(btPoint, 2, 3);

		// Buttons 1/x, %, sqrt, =.
		LargeButton btReciprocal = new LargeButton("1/x");
		LargeButton btPercent = new LargeButton("%");
		LargeButton btSqrt = new LargeButton("sqrt");
		LargeButton btEquals = new LargeButton("=");
		gridPane.add(btReciprocal, 0, 4);
		gridPane.add(btPercent, 1, 4);
		gridPane.add(btSqrt, 2, 4);
		gridPane.add(btEquals, 3, 4);
		btReciprocal.setOnAction(e ->
		{
			if (hasOperator() == false)
			{
				value = Double.parseDouble(text.getText());
				value = 1 / value;
				answer = new BigDecimal(value).toPlainString();
				text.setText(answer);
			}
		});
		btPercent.setOnAction(e ->
		{
			if (hasOperator() == false)
			{
				value = Double.parseDouble(text.getText());
				value = value / 100.0;
				answer = new BigDecimal(value).setScale(6, BigDecimal.ROUND_CEILING).toString();

				// Cut the redundant 0 int the end of double value.
				if (answer.indexOf(".") != -1)
				{
					while (answer.endsWith("0"))
						answer = answer.substring(0, answer.length() - 1);
					if (answer.endsWith("."))	// Cut the point in the end of the number string.
						answer = answer.substring(0, answer.length() - 1);
				}

				text.setText(answer);
			}
		});
		btSqrt.setOnAction(e ->
		{
			if (hasOperator() == false)
			{
				value = Double.parseDouble(text.getText());
				value = Math.sqrt(value);
				answer = new BigDecimal(value).setScale(6, BigDecimal.ROUND_CEILING).toString();

				// Cut the redundant 0 int the end of double value.
				if (answer.indexOf(".") != -1)
				{
					while (answer.endsWith("0"))
						answer = answer.substring(0, answer.length() - 1);
					if (answer.endsWith("."))
						answer = answer.substring(0, answer.length() - 1);
				}

				text.setText(answer);
			}
		});
		btEquals.setOnAction(e ->
		{
			operation = text.getText();
			calculate();
			text.setText(answer);
		});

		// Buttons of clear and backspace
		Button btClear = new Button("Clear");
		btClear.setPrefWidth(85);
		btClear.setPrefHeight(30);
		btClear.setOnAction(e -> clearHandler());
		Button btBackSpace = new Button("\u232B");
		btBackSpace.setPrefWidth(80);
		btBackSpace.setPrefHeight(30);
		btBackSpace.setOnAction(e -> backSpaceHandler());

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btClear, btBackSpace);

		VBox vBox = new VBox();
		vBox.getChildren().addAll(hBox, gridPane);

		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		BorderPane.setMargin(text, new Insets(5));
		borderPane.setTop(text);
		borderPane.setCenter(vBox);

		return borderPane;
	}

	private static void clearHandler()
	{
		value = 0;
		answer = "";
		operation = "";
		text.setText("");
	}

	private static void addPoint()
	{
		operation = text.getText();
		if (operation.indexOf(".") == -1)
		{
			text.appendText(".");
			return;
		}


		int flag = 0;
		if (operation.length() > 0 && operation.startsWith("-"))
		{
			flag = 1;
			operation = operation.substring(1);
		}
		if (operation.indexOf(".") == -1)
		{
			text.appendText(".");
			return;
		}

		// If the procedure reach here, ther is a operator in the expression, then add the point to the
		// right operand if possible.
		String[] right = operation.split("[ ¡ +-]");
		if (right.length > 1)
		{
			if (right[1].indexOf(".") == -1)
				text.appendText(".");
		}
	}

	private static void backSpaceHandler()
	{
		String content = text.getText();
		if (content.equals("") == false)
			text.setText(content.substring(0, content.length() - 1));
	}

	private static void calculate(String nextOperator)
	{
		calculate();
		text.setText(answer + nextOperator);
	}

	private static void calculate()
	{
		operation = text.getText();
		int flag = 0;
		if (operation.length() > 0 && operation.startsWith("-"))
		{
			flag = 1;
			operation = operation.substring(1);
		}

		String[] expression = operation.split("[ ¡ +-]");
		double left;
		double right;

		if (expression.length == 1)
			value = Double.parseDouble(operation);
		else
		{
			if (expression[0].equals(""))
			{
				left = 0;
				right = Double.parseDouble(expression[1]);
			}
			else
			{
				left = Double.parseDouble(expression[0]);
				right = Double.parseDouble(expression[1]);
			}

			if (flag == 1)
				left = -left;

			String operator = operation.substring(expression[0].length(), expression[0].length() + 1);
			switch (operator)
			{
			case "+": value = left + right; break;
			case "-": value = left - right; break;
			case "*": value = left * right; break;
			case "/": value = left / right; break;
			default: break;
			}
		}
		answer = new BigDecimal(value).toPlainString();
		text.setText(answer);
	}

	private static boolean hasOperator()
	{
		return hasOperator(operation);
	}

	private static boolean hasOperator(String operation)
	{
		return !(operation.indexOf("+") == -1
				&& operation.indexOf("-") == -1
				&& operation.indexOf("  ") == -1
				&& operation.indexOf("  ") == -1);
	}
}

class LargeButton extends Button
{
	private LargeButton()
	{}

	public LargeButton(String text)
	{
		super(text);
		setPrefWidth(40);
		setPrefHeight(30);
	}
}

