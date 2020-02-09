package cs134.miracosta.edu.ahernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.ahernandez.model.ShipItem;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText ;

    private TextView baseCostTextView ;
    private TextView addedCostTextView ;
    private TextView totalCostTextView ;

    private ShipItem shipItem ;

    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault()) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem() ;

        weightEditText = findViewById(R.id.weightEditText) ;
        weightEditText.requestFocus() ;

        baseCostTextView = findViewById(R.id.baseCostTextView) ;
        addedCostTextView = findViewById(R.id.addedCostTextView) ;
        totalCostTextView = findViewById(R.id.totalShippingCostTextView) ;

        weightEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Doesn't matter.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Read the input from the amountExitText 9View) and store the currentBill (Model)
                int enteredWeight ;

                try
                {
                    enteredWeight = Integer.parseInt(weightEditText.getText().toString()) ;
                } catch(NumberFormatException e) {
                    enteredWeight = 0 ;
                }
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
