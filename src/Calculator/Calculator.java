package Calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.ArrayList;


public class Calculator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox totalPane = new VBox(10);
        HBox inputPane = new HBox();
        ArrayList<HBox> hBoxes = new ArrayList<>();
        VBox totalVbox = new VBox(5);
        HBox totalHbox = new HBox(5);
        hBoxes.add(new HBox(5));
        hBoxes.add(new HBox(5));
        hBoxes.add(new HBox(5));
        hBoxes.add(new HBox(5));


        TextField textField = new TextField();
        textField.setEditable(false);
        textField.setPrefColumnCount(14);
        inputPane.getChildren().addAll(textField);



        Button btAdd = new Button("+");
        Button btSub = new Button("-");
        Button btMul = new Button("*");
        Button btDiv = new Button("/");
        Button btDou = new Button(". ");
        Button btRes = new Button("=");
        Button btNum0 = new Button("0"), btNum1 = new Button("1"), btNum2 = new Button("2"), btNum3 = new Button("3"),
                btNum4 = new Button("4"), btNum5 = new Button("5"), btNum6 =new Button("6"), btNum7 = new Button("7"),
                btNum8 = new Button("8"), btNum9 = new Button("9");

        btAdd.setOnAction(event -> setChar(textField, "+"));
        btSub.setOnAction(event -> setChar(textField, "-"));
        btMul.setOnAction(event -> setChar(textField, "*"));
        btDiv.setOnAction(event -> setChar(textField, "/"));
        btDou.setOnAction(event -> setChar(textField, "."));
        btRes.setOnAction(event -> calculate(textField));
        btNum0.setOnAction(event -> addChar(textField, "0"));
        btNum1.setOnAction(event -> addChar(textField, "1"));
        btNum2.setOnAction(event -> addChar(textField, "2"));
        btNum3.setOnAction(event -> addChar(textField, "3"));
        btNum4.setOnAction(event -> addChar(textField, "4"));
        btNum5.setOnAction(event -> addChar(textField, "5"));
        btNum6.setOnAction(event -> addChar(textField, "6"));
        btNum7.setOnAction(event -> addChar(textField, "7"));
        btNum8.setOnAction(event -> addChar(textField, "8"));
        btNum9.setOnAction(event -> addChar(textField, "9"));

        int btWidth = 30;
        btAdd.setPrefWidth(btWidth);
        btSub.setPrefWidth(btWidth);
        btMul.setPrefWidth(btWidth);
        btDiv.setPrefWidth(btWidth);
        btDou.setPrefWidth(btWidth);
        btRes.setPrefWidth(btWidth);
        btNum0.setPrefWidth(btWidth);
        btNum1.setPrefWidth(btWidth);
        btNum2.setPrefWidth(btWidth);
        btNum3.setPrefWidth(btWidth);
        btNum4.setPrefWidth(btWidth);
        btNum5.setPrefWidth(btWidth);
        btNum6.setPrefWidth(btWidth);
        btNum7.setPrefWidth(btWidth);
        btNum8.setPrefWidth(btWidth);
        btNum9.setPrefWidth(btWidth);

        hBoxes.get(0).getChildren().addAll(btNum7, btNum8, btNum9, btAdd);
        hBoxes.get(0).setAlignment(Pos.CENTER);
        hBoxes.get(1).getChildren().addAll(btNum4, btNum5, btNum6, btSub);
        hBoxes.get(1).setAlignment(Pos.CENTER);
        hBoxes.get(2).getChildren().addAll(btNum1, btNum2, btNum3, btMul);
        hBoxes.get(2).setAlignment(Pos.CENTER);
        hBoxes.get(3).getChildren().addAll(btDou, btNum0, btRes, btDiv);
        hBoxes.get(3).setAlignment(Pos.CENTER);

        Button btClear = new Button("CE");
        Button btBack  = new Button("<-");
        Button btSqrt = new Button("sqrt");
        Button btReverse = new Button("1/x");

        btClear.setPrefWidth(40);
        btReverse.setPrefWidth(40);
        btSqrt.setPrefWidth(40);
        btBack.setPrefWidth(40);
        btClear.setOnAction(event -> clear(textField));
        btBack.setOnAction(event -> back(textField));
        btSqrt.setOnAction(event -> sqrt(textField));
        btReverse.setOnAction(event -> reverse(textField));
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(btClear,btBack, btSqrt, btReverse);

        totalPane.setOnKeyPressed(event ->
        {
            switch (event.getCode())
            {
                case DIGIT0:
                case NUMPAD0:addChar(textField, "0");break;
                case DIGIT1:
                case NUMPAD1:addChar(textField, "1");break;
                case DIGIT2:
                case NUMPAD2:addChar(textField, "2");break;
                case DIGIT3:
                case NUMPAD3:addChar(textField, "3");break;
                case DIGIT4:
                case NUMPAD4:addChar(textField, "4");break;
                case DIGIT5:
                case NUMPAD5:addChar(textField, "5");break;
                case DIGIT6:
                case NUMPAD6:addChar(textField, "6");break;
                case DIGIT7:
                case NUMPAD7:addChar(textField, "7");break;
                case DIGIT8:
                case NUMPAD8:addChar(textField, "8");break;
                case DIGIT9:
                case NUMPAD9:addChar(textField, "9");break;
                case ADD:setChar(textField,  "+");break;
                case SUBTRACT:setChar(textField, "-");break;
                case MULTIPLY:setChar(textField, "*");break;
                case DIVIDE:setChar(textField, "/");break;
                case DECIMAL:setChar(textField, ".");break;
                case BACK_SPACE:back(textField);break;
                case ENTER:calculate(textField);break;
            }

        });

        textField.setOnKeyPressed(event ->
        {
            switch (event.getCode())
            {
                case DIGIT0:
                case NUMPAD0:addChar(textField, "0");break;
                case DIGIT1:
                case NUMPAD1:addChar(textField, "1");break;
                case DIGIT2:
                case NUMPAD2:addChar(textField, "2");break;
                case DIGIT3:
                case NUMPAD3:addChar(textField, "3");break;
                case DIGIT4:
                case NUMPAD4:addChar(textField, "4");break;
                case DIGIT5:
                case NUMPAD5:addChar(textField, "5");break;
                case DIGIT6:
                case NUMPAD6:addChar(textField, "6");break;
                case DIGIT7:
                case NUMPAD7:addChar(textField, "7");break;
                case DIGIT8:
                case NUMPAD8:addChar(textField, "8");break;
                case DIGIT9:
                case NUMPAD9:addChar(textField, "9");break;
                case ADD:setChar(textField,  "+");break;
                case SUBTRACT:setChar(textField, "-");break;
                case MULTIPLY:setChar(textField, "*");break;
                case DIVIDE:setChar(textField, "/");break;
                case DECIMAL:setChar(textField, ".");break;
                case BACK_SPACE:back(textField);break;
                case ENTER:calculate(textField);break;
            }

        });

        textField.requestFocus();


        totalVbox.getChildren().addAll(hBoxes.get(0), hBoxes.get(1), hBoxes.get(2), hBoxes.get(3));
        totalHbox.getChildren().addAll(totalVbox, vBox);
        totalPane.getChildren().addAll(inputPane, totalHbox);

        totalPane.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.setScene(new Scene(totalPane, 200, 163));
        primaryStage.setTitle("Calculator");
        primaryStage.show();

        totalPane.requestFocus();
    }


    public void addChar(TextField textField, String s)
    {
        if (textField.getText().equals("0"))
            textField.setText(s);
        else
            textField.setText(textField.getText() + s);
    }

    public void setChar(TextField textField, String s)
    {
        if (!textField.getText().isEmpty())
        {
            if (textField.getText().endsWith(".") || textField.getText().endsWith("+") ||textField.getText().endsWith("-")
                    ||textField.getText().endsWith("*") ||textField.getText().endsWith("/"))
                textField.setText(textField.getText(0, textField.getText().length() - 1) + s);
            else
                textField.setText(textField.getText() + s);
        }
    }

    public void clear(TextField textField)
    {
        textField.setText("");
    }

    public void back(TextField textField)
    {
        if (!textField.getText().isEmpty())
            textField.setText(textField.getText(0, textField.getText().length() - 1));
    }

    public void sqrt(TextField textField)
    {
        if (!textField.getText().isEmpty()) {
            calculate(textField);
            textField.setText(Math.sqrt(Double.parseDouble(textField.getText())) + "");
        }
    }

    public void reverse(TextField textField)
    {
        if (!textField.getText().isEmpty()) {
            calculate(textField);
            textField.setText(1 / Double.parseDouble(textField.getText()) + "");
        }
    }

    public void calculate(TextField textField)
    {
        textField.setText(filter(textField));
        int lastLocation = 0;
        ArrayList<String> icons = filterIcon(textField);
        ArrayList<String> nums = filterNum(textField);
        /*for (String icon: icons)
            System.out.print(icon + " ");
        for (String num: nums)
            System.out.print(num + " ");*/

        for (String icon: icons)
        {
            if (icon.equals("*"))
            {
                int index = icons.indexOf(icon);
                lastLocation = index;
                BigDecimal tempNum = new BigDecimal(nums.get(index)).multiply(new BigDecimal(nums.get(index + 1)));
                nums.set(index, tempNum.toString());
                nums.set(index + 1, tempNum.toString());
            }
            else if (icon.equals("/"))
            {//注意处理除零错误
                int index = icons.indexOf(icon);
                lastLocation = index;
                BigDecimal tempNum;
                if (nums.get(index + 1).equals("0"))
                {
                    nums.set(index, "The divisor cannot be zero");
                    nums.set(index + 1, "The divisor cannot be zero");
                }
                else
                {
                    tempNum = new BigDecimal(nums.get(index)).divide(new BigDecimal(nums.get(index + 1)));
                    nums.set(index, tempNum.toString());
                    nums.set(index + 1, tempNum.toString());
                }
            }
        }

        for (String icon: icons)
        {
            if (icon.equals("+"))
            {
                int index = icons.indexOf(icon);
                lastLocation = index;
                BigDecimal tempNum = new BigDecimal(nums.get(index)).add(new BigDecimal(nums.get(index + 1)));
                nums.set(index, tempNum.toString());
                nums.set(index + 1, tempNum.toString());

            }
            else if (icon.equals("-"))
            {
                int index = icons.indexOf(icon);
                lastLocation = index;
                BigDecimal tempNum = new BigDecimal(nums.get(index)).subtract(new BigDecimal(nums.get(index + 1)));
                nums.set(index, tempNum.toString());
                nums.set(index + 1, tempNum.toString());
            }
        }

        textField.setText(nums.get(lastLocation));
    }

    public ArrayList<String> filterIcon(TextField textField)
    {
        String[] icons = textField.getText().split("\\d");
        ArrayList<String> relIcons =new ArrayList<>();
        for (String icon: icons)
            if (icon.equals("+") || icon.equals("-") || icon.equals("*") || icon.equals("/"))
                relIcons.add(icon);

        return relIcons;
    }

    public ArrayList<String> filterNum(TextField textField)
    {
        String[] firstNums = textField.getText().split("[+/*]");
        ArrayList<String> relNums = new ArrayList<>();
        for (String num: firstNums)
        {
            if (num.contains("-"))
            {
                String[] nums = num.split("-");
                for (String relNum: nums)
                    relNums.add(relNum);
            }
            else
                relNums.add(num);
        }
        return relNums;
    }

    public String filter(TextField textField)
    {
        if (textField.getText().endsWith(".") ||textField.getText().endsWith("+") ||
                textField.getText().endsWith("-") || textField.getText().endsWith("*") || textField.getText().endsWith("/"))
            return textField.getText(0, textField.getText().length() - 1);
        return textField.getText();
    }
}
