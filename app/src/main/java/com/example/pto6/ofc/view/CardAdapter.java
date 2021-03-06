package com.example.pto6.ofc.view;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.pto6.ofc.R;
import com.example.pto6.ofc.contracts.OfcContract;
import com.example.pto6.ofc.model.UserFinance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CardAdapter<T extends UserFinance, V extends OfcContract.View>
        extends RecyclerView.Adapter<CardAdapter.PersonViewHolder> implements AdapterView.OnItemClickListener {

    private static final String TAG = "CardAdapter";
    private List<T> dataSet;
    private V viewParent;

    public CardAdapter(List<T> persons, V viewParent) {
        this.dataSet = persons;
        this.viewParent = viewParent;
    }

    public static <T extends UserFinance, V extends OfcContract.View> CardAdapter<T, V> of(List<T> persons, V viewParent) {
        return new CardAdapter<>(persons, viewParent);
    }

    public List<T> getDataSet() {
        return dataSet;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        Date create = dataSet.get(i).getCreateDate();
        Date change = dataSet.get(i).getChangeDate();

        DateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());

        personViewHolder.mTextViewName.setText(dataSet.get(i).getName());
        personViewHolder.mTextViewDate.setText(df.format(create));
        personViewHolder.mTextViewDateChange.setText(df.format(change));
        personViewHolder.mTextViewAmount.setText(String.valueOf((dataSet.get(i)).getArrival()));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_cd, viewGroup, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView mTextViewName;
        TextView mTextViewDate;
        TextView mTextViewDateChange;
        TextView mTextViewAmount;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            mTextViewName = itemView.findViewById(R.id.name);
            mTextViewDate = itemView.findViewById(R.id.create_date);
            mTextViewDateChange = itemView.findViewById(R.id.change_date);
            mTextViewAmount = itemView.findViewById(R.id.amount);
        }
    }
}
