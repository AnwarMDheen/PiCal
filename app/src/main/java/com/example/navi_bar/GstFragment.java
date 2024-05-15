package com.example.navi_bar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Stack;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GstFragment extends Fragment  implements View.OnClickListener {
    View view;
    TextView resultTv, solutionTv, solutionTv1;
    TextView net_price, cgst, sgst, icgst, total_price, exclus_text;
    MaterialButton button_home, button_print;
    MaterialButton button_Backspace;
    MaterialButton buttonC, buttonBrackopen, buttonBrackclose, buttonmode, buttonhome;
    MaterialButton buttonpercent;
    MaterialButton buttonDivide, buttonmult, buttonsubt, buttonadd, buttonequals, buttonsqrt, buttondot;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GstFragment newInstance(String param1, String param2) {
        GstFragment fragment = new GstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_gst, container, false);
        resultTv = view.findViewById(R.id.ResultView);
        solutionTv = view.findViewById(R.id.calculationView);
        assignid(buttonC, R.id.CButton);
        assignid(buttonpercent,R.id.PercentButton);
        assignid(buttonBrackopen, R.id.BracketsButton);
        assignid(button_Backspace, R.id.BackspaceButton);
        assignid(buttonDivide, R.id.DivideButton);
        assignid(buttonmult, R.id.MultiplyButton);
        assignid(buttonsubt, R.id.MinusButton);
        assignid(buttonadd, R.id.PlusButton);
        assignid(buttonequals, R.id.EqualButton);
        //assignid(buttonsqrt, R.id.button_Sqrt);
        assignid(buttondot, R.id.DotButton);
        assignid(button0, R.id.ZeroButton);
        assignid(button1, R.id.OneButton);
        assignid(button2, R.id.TwoButton);
        assignid(button3, R.id.ThreeButton);
        assignid(button4, R.id.fourButton);
        assignid(button5, R.id.fiveButton);
        assignid(button6, R.id.SixButton);
        assignid(button7, R.id.SevenButton);
        assignid(button8, R.id.EightButton);
        assignid(button9, R.id.NineButton);
        // assignid(button10, R.id.button_TwoZero)
        return view;
    }
    public void assignid(MaterialButton btn, int id) {
        btn = view.findViewById(id);
        btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String datatocal = solutionTv.getText().toString();

        if (buttonText.equals("=")) {
            String d = evaluate(datatocal);
            resultTv.setText(d);
            return;
        }
        if (buttonText.equals("C")) {
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }

        if (buttonText.equals("⌫") || button.getId() == R.id.BackspaceButton) {
            if (datatocal.length() != 0) {
                datatocal = datatocal.substring(0, datatocal.length() - 1);
                solutionTv.setText(datatocal);
            }
            return;
        } if(datatocal.length()>=40) {
            Toast.makeText(getActivity()
                    ,"characters limit exceeds",Toast.LENGTH_SHORT).show();
            return;
        }
        if(buttonText.equals("()") || button.getId()==R.id.BracketsButton) {
            if(datatocal.endsWith("+")||datatocal.endsWith("-")||datatocal.endsWith("*")||datatocal.endsWith("/")) {
                buttonText="(";
            }
            else {
                buttonText=")";
            }
        }

        datatocal = datatocal + buttonText;
        solutionTv.setText(datatocal);
        // String finalResult = getResult(datatocal);

    }
    public static String evaluate(String expression) {
        try {
            char[] tokens = expression.toCharArray();

            // Stack for numbers: 'values'
            Stack<Double> values = new
                    Stack<Double>();

            // Stack for Operators: 'ops'
            Stack<Character> ops = new
                    Stack<Character>();

            for (int i = 0; i < tokens.length; i++) {

                // Current token is a
                // whitespace, skip it
                if (tokens[i] == ' ')
                    continue;

                // Current token is a number,
                // push it to stack for numbers
                if (tokens[i] >= '0' &&
                        tokens[i] <= '9') {
                    StringBuffer sbuf = new
                            StringBuffer();

                    // There may be more than one
                    // digits in number
                    while (i < tokens.length &&
                            ((tokens[i] >= '0' &&
                                    tokens[i] <= '9') || tokens[i] == '.'))
                        sbuf.append(tokens[i++]);
                    values.push(Double.parseDouble(sbuf.
                            toString()));

                    // right now the i points to
                    // the character next to the digit,
                    // since the for loop also increases
                    // the i, we would skip one
                    //  token position; we need to
                    // decrease the value of i by 1 to
                    // correct the offset.
                    i--;
                }

                // Current token is an opening brace,
                // push it to 'ops'
                else if (tokens[i] == '(')
                    ops.push(tokens[i]);

                    // Closing brace encountered,
                    // solve entire brace
                else if (tokens[i] == ')') {
                    while (ops.peek() != '(') {
                        double v2 = values.pop();
                        double v1 = values.pop();
                        char ch2 = ops.pop();
                        double result = operation(v1, v2, ch2);
                        values.push(result);
                    }
                    ops.pop();
                }

                // Current token is an operator.
                else if (tokens[i] == '+' ||
                        tokens[i] == '-' ||
                        tokens[i] == '*' ||
                        tokens[i] == '/' || tokens[i] == '^' || tokens[i] == '%') {
                    // While top of 'ops' has same
                    // or greater precedence to current
                    // token, which is an operator.
                    // Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() && precedence(ops.peek()) >= precedence(tokens[i])) {
                        if (ops.peek() != '%') {
                            double v2 = values.pop();
                            double v1 = values.pop();
                            char ch2 = ops.pop();
                            double result = operation(v1, v2, ch2);
                            values.push(result);
                        } else {
                            try{
                                double v2 = values.pop();
                                char ch2 = ops.pop();
                                double result = operation1(v2, ch2);
                                values.push(result);}
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    // Push current token to 'ops'.
                    ops.push(tokens[i]);
                }
            }

            // Entire expression has been
            // parsed at this point, apply remaining
            // ops to remaining values
            while (!ops.empty()) {
                double v2 = values.pop();
                double v1 = values.pop();
                char ch2 = ops.pop();
                double result = operation(v1, v2, ch2);
                values.push(result);
            }

            // Top of 'values' contains
            // result, return it
            return values.pop().toString();
        } catch (Exception e) {
            return "SYNTAX ERROR";
        }

    }

    public static int precedence(char operators) {
        if (operators == '+' || operators == '-') {
            return 1;
        }
        if (operators == '*' || operators == '/') {
            return 2;
        }
        if (operators == '^') {
            return 3;
        }
        if (operators == '%') {
            return 4;
        } else {
            return 0;
        }
    }

    public static double operation(double v1, double v2, char op) {
        if (op == '+') {
            return (v1 + v2);
        } else if (op == '-') {
            return (v1 - v2);
        } else if (op == '*') {
            return (v1*v2);
        } else if (op == '/') {
            return ((double) v1 / v2);
        } else if (op == '^') {
            return ((double) Math.pow(v1, v2));
        }
        else {
            return 1;
        }
    }

    public static double operation1(double v2, char op) {
        return (v2 * 0.01);
    }
}