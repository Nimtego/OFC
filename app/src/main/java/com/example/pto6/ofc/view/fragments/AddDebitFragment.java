package com.example.pto6.ofc.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.pto6.ofc.R;
import com.example.pto6.ofc.dto.DebitDTO;
import com.example.pto6.ofc.dto.UserFinanceDTO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddDebitFragment extends DataEntryFragment {
    private static final String TAG = "<< AddDebitFragment >> - ";

    @BindView(R.id.input_name_edit_text)
    EditText name;
    @BindView(R.id.input_amount_edit_text)
    EditText amount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_debit, null);
        setUnBinder(ButterKnife.bind(rootView));
        name = rootView.findViewById(R.id.input_name_edit_text);
        amount = rootView.findViewById(R.id.input_amount_edit_text);
        rootView.findViewById(R.id.button_add).setOnClickListener(view -> listener.onAddPressed());
        rootView.findViewById(R.id.button_cancel).setOnClickListener(view -> listener.onCancelPressed());
        return rootView;
    }

    @Override
    public UserFinanceDTO getFormData() {
        return DebitDTO.builder().name(String.valueOf(name.getText())).amount(amount.getText().toString()).build();
    }

}
