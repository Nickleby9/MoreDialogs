package hilay.edu.moredialogs;


import android.content.Context;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends DialogFragment implements View.OnClickListener {

    EditText etPassword, etUsername;
    Button btnLogin;
    Button btnCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Ness","Fragment has been started");
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etUsername = (EditText) view.findViewById(R.id.etUsername);
        etPassword = (EditText) view.findViewById(R.id.etPassword);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnLogin){
            String userName = etUsername.getText().toString();
//            ((OnUserLoggedInListener) getActivity()).onUserLoggedIn(userName);
//            split declaration:

            listener.onUserLoggedIn(userName);
            Toast.makeText((Context) listener, "" + userName, Toast.LENGTH_SHORT).show();
        } else {

        }

        dismiss();
    }

    public interface OnUserLoggedInListener {
        //sends the username to the activity who implements this method
        void onUserLoggedIn(String userName);
    }

    OnUserLoggedInListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//      makes sure the the activity that uses the fragment (.show()) -
//      implemented the interface.
        if (context instanceof OnUserLoggedInListener){
            listener = (OnUserLoggedInListener) context;
        } else {
            throw new RuntimeException("ERROR: " + context + "has not implemented" + listener.getClass().getSimpleName());
        }
    }
}
