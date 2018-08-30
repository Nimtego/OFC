package com.example.pto6.ofc.view;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pto6.ofc.OfcApplication;
import com.example.pto6.ofc.R;
import com.example.pto6.ofc.contracts.OfcContract;
import com.example.pto6.ofc.model.Credit;
import com.example.pto6.ofc.model.Debit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OfcListActivity extends BaseView<OfcContract.OfcPresenter>
        implements OfcContract.OfcView<OfcContract.OfcPresenter>, TabLayout.OnTabSelectedListener {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofc_list);
        ButterKnife.bind(this);
        // setUnBinder(ButterKnife.bind(this));
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.viewIsReady();
    }

    private void init() {
        setUpRecyclerView();
        tabs.addTab(tabs.newTab().setText("Debit"));
        tabs.addTab(tabs.newTab().setText("Credit"));
        tabs.addTab(tabs.newTab().setText("Data"));
        tabs.addOnTabSelectedListener(this);
        // fab.setOnClickListener(mPresenter);
    }

    private void setUpRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        // mRecyclerView.addOnItemTouchListener(mPresenter);
    }
    @OnClick(R.id.recycler_view)
    void onClick(){}

  /*  @Override
    public Presenter setPresenter() {
        return OfcApplication.getPresenterComponent().getOfcListPresenter();
    }

    @Override
    public void setUserFinance(RecyclerView.Adapter mAdapter) {
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    @Override
    public TabLayout getTabLayout() {
        return tabs;
    }*/

    @Override
    public void setDebitListView(List<? extends Debit> listDebit) {

    }

    @Override
    public void setCredittListView(List<? extends Credit> listCredit) {

    }

    @Override
    public OfcContract.OfcPresenter supplyPresenter() {
        return OfcApplication.getPresenterComponent().getOfcListPresenter();

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
