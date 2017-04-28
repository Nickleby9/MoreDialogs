package hilay.edu.moredialogs;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements LoginFragment.OnUserLoggedInListener{
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout) findViewById(R.id.constraint);
    }

    public void showDialog(View view) {
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        View v = getLayoutInflater()
//                .inflate(R.layout.dialog_login, layout, false);
//
//        builder.setCancelable(false);
//        builder.setView(v);
//        final AlertDialog dialog = builder.create();
//
//        final EditText etUsername = (EditText) v.findViewById(R.id.etUsername);
//
//        EditText etPassword = (EditText) v.findViewById(R.id.etPassword);
//        Button btnLogin = (Button) v.findViewById(R.id.btnLogin);
//        Button btnCancel = (Button) v.findViewById(R.id.btnCancel);
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Hello, " + etUsername.getText(), Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();

        LoginFragment f = new LoginFragment();
        f.show(getSupportFragmentManager(), "loginDialog");

    }

    @Override
    public void onUserLoggedIn(String userName) {
        //gets the username from the dialog so the activity will know who logged on
    }
}
