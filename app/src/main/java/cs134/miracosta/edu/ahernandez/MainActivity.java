package cs134.miracosta.edu.ahernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.ahernandez.model.ShipItem;

/**
 * The MainActivity class is the default activity of the Shipping Calculator
 * used to display the price of shipping an item.
 * Alfredo Hernandez Jr
 * CS 134 - Project 01: Shipping Calculator
 */
public class MainActivity extends AppCompatActivity {

    // EditText and TextView connectors.
    private EditText weightEditText ;

    private TextView baseCostTextView ;
    private TextView addedCostTextView ;
    private TextView totalCostTextView ;

    // ShipItem used to calculate the cost of shipping items.
    private ShipItem shipItem ;

    // Formats the calculated cost into the local currency.
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault()) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem() ;

        /** Connects the Objects to the TextBoxes in activity_main.xml */
        weightEditText = findViewById(R.id.weightEditText) ;
        baseCostTextView = findViewById(R.id.baseCostTextView) ;
        addedCostTextView = findViewById(R.id.addedCostTextView) ;
        totalCostTextView = findViewById(R.id.totalShippingCostTextView) ;

        // Defaults the focus to the weightEditText.
        weightEditText.requestFocus() ;
        // Makes the soft keyboard appear.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE) ;

        // Overrides the onTextChanged method in order to display changes in price.
        weightEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Doesn't matter.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Read the input from the weightEditText.
                int enteredWeight ;

                try
                {
                    enteredWeight = Integer.parseInt(weightEditText.getText().toString()) ;
                } catch(NumberFormatException e) {
                    enteredWeight = 0 ;
                }

                // Sets the weight of the package which calculates the rest of the parameters.
                shipItem.setWeightOfThePackage(enteredWeight) ;

                baseCostTextView.setText(currency.format(shipItem.getBaseCost())) ;
                addedCostTextView.setText(currency.format(shipItem.getAddedCost())) ;
                totalCostTextView.setText(currency.format(shipItem.getTotalShippingCost())) ;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Doesn't matter
            }
        }) ;
    }
}
