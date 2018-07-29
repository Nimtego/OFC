package com.example.pto6.ofc.model;



import java.util.Date;

interface Credit extends UserFinance{
    Date dateOfCapture();
    int numberOfMonths();
    int percent();
    float arrivalSize();
    CreditType creditType();
}