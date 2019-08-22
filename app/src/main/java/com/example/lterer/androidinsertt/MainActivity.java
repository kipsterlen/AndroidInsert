package com.example.lterer.androidinsertt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button SubmitButton ;

    EditText homeEditText, awayEditText, pickEditText;

    // Declaring String variable ( In which we are storing firebase server URL ).
    public static final String Firebase_Server_URL = "https://androidinsertt.firebaseio.com/";

    // Declaring String variables to store name & phone number get from EditText.
    String homeHolder, awayHolder,pickHolder;

    Firebase firebase;

    DatabaseReference databaseReference;

    // Root Database Name for Firebase Database.
    public static final String Database_Path = "Student_Details_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(MainActivity.this);

        firebase = new Firebase(Firebase_Server_URL);

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        SubmitButton = (Button)findViewById(R.id.submit);

        homeEditText = (EditText)findViewById(R.id.home);

        awayEditText = (EditText)findViewById(R.id.away);
        pickEditText = (EditText)findViewById(R.id.pick);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StudentDetails studentDetails = new StudentDetails(homeHolder,awayHolder,pickHolder);

                GetDataFromEditText();

                // Adding name into class function object.
                //studentDetails.setStudentName(NameHolder);

                // Adding phone number into class function object.
                //studentDetails.setStudentPhoneNumber(NumberHolder);

                // Getting the ID from firebase database.
                String StudentRecordIDFromServer = databaseReference.push().getKey();

                // Adding the both name and number values using student details class object using ID.
                databaseReference.child(StudentRecordIDFromServer).setValue(studentDetails);

                // Showing Toast message after successfully data submit.
                Toast.makeText(MainActivity.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();
                pickEditText.setText("");

            }
        });

    }

    public void GetDataFromEditText(){

        homeHolder = homeEditText.getText().toString().trim();

        awayHolder = awayEditText.getText().toString().trim();
        pickHolder = pickEditText.getText().toString().trim();

    }
}