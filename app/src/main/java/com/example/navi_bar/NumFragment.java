package com.example.navi_bar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String item,item1;
    EditText e1,e2;
    AutoCompleteTextView autoCompleteTextView1;
    AutoCompleteTextView autoCompleteTextView2;
    TextView  fromtext,totext;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;

    public NumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumFragment newInstance(String param1, String param2) {
        NumFragment fragment = new NumFragment();
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
        view= inflater.inflate(R.layout.fragment_num, container, false);
        autoCompleteTextView1=view.findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView2=view.findViewById(R.id.autoCompleteTextView1);
        fromtext=view.findViewById(R.id.tv_fromUnit);
        totext=view.findViewById(R.id.tv_toUnit);
        e1=view.findViewById(R.id.et_fromUnit);
        e2=view.findViewById(R.id.et_toUnit);
        String arr[]=getResources().getStringArray(R.array.numbersys);
        ArrayAdapter arrayAdapter=new ArrayAdapter<>(requireContext(),R.layout.dropdown_item,arr);
        autoCompleteTextView1.setAdapter(arrayAdapter);
        autoCompleteTextView2.setAdapter(arrayAdapter);
        fromtext.setText("decimal");
        totext.setText("decimal");
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 item=parent.getItemAtPosition(position).toString();
                //Toast.makeText(getActivity(),item, Toast.LENGTH_SHORT).show();
                fromtext.setText(item);

            }
        });
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item1=parent.getItemAtPosition(position).toString();
                totext.setText(item1);
                if (autoCompleteTextView1.getText().toString().contains("hexadecimal")) {
                    if (autoCompleteTextView2.getText().toString().contains("binary")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = hexadecimalconverter.hexToBinary(Float.toString(st));
                            e2.setText(ans);
                        }
                    } else if (autoCompleteTextView2.getText().toString().contains("octal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = hexadecimalconverter.hexToOctal(Float.toString(st));
                            e2.setText(ans);

                        }
                    } else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                        if (!e1.getText().toString().isEmpty()) {
//                            float st = Float.parseFloat(e1.getText().toString());
//                            Double ans = hexadecimalconverter.hexToDecimal(Float.toString(st));
//                            e2.setText(Double.toString(ans));
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = e1.getText().toString();
                            e2.setText(ans);
                        }
                         } else if (autoCompleteTextView2.getText().toString().contains("decimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = String.valueOf(hexadecimalconverter.hexToDecimal(Float.toString(st)));
                                 e2.setText(ans);

                             }
                    } else {
                        if (!e1.getText().toString().isEmpty()) {

                        }
                    }
                }
                else if (autoCompleteTextView1.getText().toString().contains("octal")) {
                    if (autoCompleteTextView2.getText().toString().contains("binary")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = octalconverter.octalToBinary(Float.toString(st));
                            e2.setText(ans);
                        }
                    } else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = binaryconverter.convertBinaryToHexadecimal(octalconverter.octalToBinary(Float.toString(st)));
                            e2.setText(ans);

                        }
                    } else if (autoCompleteTextView2.getText().toString().contains("decimal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            Double ans = octalconverter.octalToDecimal(Float.toString(st));
                            e2.setText(Double.toString(ans));

                        }
//                         } else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
//                             if (!e1.getText().toString().isEmpty()) {
//                                 float st = Float.parseFloat(e1.getText().toString());
//                                 String ans = decimalconverter.convertDecimalToHexadecimal(st);
//                                 e2.setText(ans);
//
//                             }
                    } else {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = e1.getText().toString();
                            e2.setText(ans);
                        }
                    }
                }
               else if (autoCompleteTextView1.getText().toString().contains("decimal")) {
                    if (autoCompleteTextView2.getText().toString().contains("binary")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = decimalconverter.convertDecimalToBinary(st);
                            e2.setText(ans);
                        }
                    }
                   else if (autoCompleteTextView2.getText().toString().contains("octal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = decimalconverter.convertDecimalToOctal(st);
                            e2.setText(ans);

                        }
                    }
                  else  if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = decimalconverter.convertDecimalToHexadecimal(st);
                            e2.setText(ans);

                        }
                    }
                   else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = decimalconverter.convertDecimalToHexadecimal(st);
                            e2.setText(ans);

                        }
                    }
                    else {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = e1.getText().toString();
                            e2.setText(ans);
                        }
                    }
                } else if (autoCompleteTextView1.getText().toString().contains("binary")) {
                    if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = (binaryconverter.convertBinaryToHexadecimal(Float.toString(st)));
                            e2.setText(ans);
                        }
                    } else if (autoCompleteTextView2.getText().toString().contains("octal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = binaryconverter.binaryToOctal(Float.toString(st));
                            e2.setText(ans);

                        }
                    } else if (autoCompleteTextView2.getText().toString().contains("decimal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = String.valueOf(binaryconverter.convertBinaryToDecimal(Float.toString(st)));
                            e2.setText(ans);

                        }
                    } else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = binaryconverter.convertBinaryToHexadecimal(String.valueOf(st));
                            e2.setText(ans);

                        }
                    } else {
                        if (!e1.getText().toString().isEmpty()) {
                            float st = Float.parseFloat(e1.getText().toString());
                            String ans = e1.getText().toString();
                            e2.setText(ans);
                        }
                    }
                }
                }
        });
         e1.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 try {
                     if (autoCompleteTextView1.getText().toString().contains("hexadecimal")) {
                         if (autoCompleteTextView2.getText().toString().contains("binary")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = hexadecimalconverter.hexToBinary(Float.toString(st));
                                 e2.setText(ans);
                             }
                         } else if (autoCompleteTextView2.getText().toString().contains("octal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = hexadecimalconverter.hexToOctal(Float.toString(st));
                                 e2.setText(ans);

                             }
                         } else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = e1.getText().toString();
                                 e2.setText(ans);

                             }
                         } else if (autoCompleteTextView2.getText().toString().contains("decimal")) {
                             if (!e1.getText().toString().isEmpty()) {
//                                 float st = Float.parseFloat(e1.getText().toString());
//                                 String ans = decimalconverter.convertDecimalToHexadecimal(st);
//                                 e2.setText(ans);
                                 float st = Float.parseFloat(e1.getText().toString());
                                 Double ans = hexadecimalconverter.hexToDecimal(Float.toString(st));
                                 e2.setText(Double.toString(ans));
                             }
                         } else {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = e1.getText().toString();
                                 e2.setText(ans);
                             }
                         }
                     }
                    else if (autoCompleteTextView1.getText().toString().contains("octal")) {
                         if (autoCompleteTextView2.getText().toString().contains("binary")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = octalconverter.octalToBinary(Float.toString(st));
                                 e2.setText(ans);
                             }
                         } else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans =  binaryconverter.convertBinaryToHexadecimal(octalconverter.octalToBinary(Float.toString(st)));//octalconverter.octalToHexadecimal(Float.toString(st));
                                 e2.setText(ans);

                             }
                         } else if (autoCompleteTextView2.getText().toString().contains("decimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 Double ans = octalconverter.octalToDecimal(Float.toString(st));
                                 e2.setText(Double.toString(ans));

                             }
//                         } else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
//                             if (!e1.getText().toString().isEmpty()) {
//                                 float st = Float.parseFloat(e1.getText().toString());
//                                 String ans = decimalconverter.convertDecimalToHexadecimal(st);
//                                 e2.setText(ans);
//
//                             }
                         } else {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = e1.getText().toString();
                                 e2.setText(ans);
                             }
                         }
                     }
                    else if (autoCompleteTextView1.getText().toString().contains("decimal")) {
                         if (autoCompleteTextView2.getText().toString().contains("binary")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = decimalconverter.convertDecimalToBinary(st);
                                 e2.setText(ans);
                             }
                         }
                        else if (autoCompleteTextView2.getText().toString().contains("octal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = decimalconverter.convertDecimalToOctal(st);
                                 e2.setText(ans);

                             }
                         }
                        else if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = decimalconverter.convertDecimalToHexadecimal(st);
                                 e2.setText(ans);

                             }
                         }
                       else  if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = decimalconverter.convertDecimalToHexadecimal(st);
                                 e2.setText(ans);

                             }
                         }
                         else {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = e1.getText().toString();
                                 e2.setText(ans);
                             }
                         }
                     }
                     //for binary
                    else if (autoCompleteTextView1.getText().toString().contains("binary")) {
                         if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans =binaryconverter.convertBinaryToHexadecimal(Float.toString(st));
                                 e2.setText(ans);
                             }
                         }
                         else if (autoCompleteTextView2.getText().toString().contains("octal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = binaryconverter.binaryToOctal(Float.toString(st));
                                 e2.setText(ans);

                             }
                         }
                         else if (autoCompleteTextView2.getText().toString().contains("decimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = String.valueOf(binaryconverter.convertBinaryToDecimal(Float.toString(st)));
                                 e2.setText(ans);

                             }
                         }
                         else  if (autoCompleteTextView2.getText().toString().contains("hexadecimal")) {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = binaryconverter.convertBinaryToHexadecimal(String.valueOf(st));
                                 e2.setText(ans);

                             }
                         }
                         else {
                             if (!e1.getText().toString().isEmpty()) {
                                 float st = Float.parseFloat(e1.getText().toString());
                                 String ans = e1.getText().toString();
                                 e2.setText(ans);
                             }
                         }
                     }
                 }catch (Exception e) {
                       e2.setText(" ");
                 }
             }

             @Override
             public void afterTextChanged(Editable s) {
                 String sw=e1.getText().toString();
                 if(sw.isEmpty()){
                     e2.setText(" ");
                 }

             }
         });
        //fromtext.setText(autoCompleteTextView1.getText().toString());
        //totext.setText(autoCompleteTextView2.getText().toString());;
        return view;
    }
}