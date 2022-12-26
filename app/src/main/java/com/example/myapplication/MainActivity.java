package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    FirebaseAuth mAuth;
//    FirebaseDatabase db;
//    TextView ok;
    private static final String TAG = "MainActivity";
    private static final String key_title = "title";
    private static final String key_des = "description";
    private EditText editTextTitle;
    private EditText editTextDes;
    private EditText editTextPriority;
    private TextView viewData;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef =db.collection("Notebook");
    private DocumentReference noteRef = db.collection("Notebook")
            .document("5taecpoRckBuv5ZAW4AI");
    //private DocumentReference noteRef = db.document("Notebook/5taecpoRckBuv5ZAW4AI");
    //private ListenerRegistration noteListener; //save our notes listener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.title);
        editTextDes = findViewById(R.id.description);
        viewData = findViewById(R.id.viewData);
        editTextPriority=findViewById(R.id.priority);

        //global data
        GlobalData global = (GlobalData) getApplicationContext();
        Log.d("global from main",global.myGlobal);
        global.myGlobal = "changed global";
//        Intent i =new Intent(this,register.class);
//        startActivity(i);
//        mAuth=FirebaseAuth.getInstance();
//        mAuth.signInWithEmailAndPassword("saad@gmail.com","ok123456ok").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
//                    Log.d("login","done");
//
//                }else{
//                    Toast.makeText(MainActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    Log.d("login","not done");
//                }
//            }
//        });
//        ok=findViewById(R.id.ok);
//        //FirebaseDatabase.getInstance().getReference("category_info").push().child("name").setValue("gaming");
//        FirebaseDatabase.getInstance().getReference("category_info").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange( DataSnapshot snapshot) {
//                // this method is call to get the realtime
//                // updates in the data.
//                // this method is called when the data is
//                // changed in our Firebase console.
//                // below line is for getting the data from
//                // snapshot of our database.
//                // value = snapshot.getChildren();
//                for (DataSnapshot shot : snapshot.getChildren()) {
//                    Log.d("ok",shot.getKey());
//                }
//                Log.d("ok",snapshot.getChildren().getClass().toString());
//                Log.d("hello","hello");
//                //System.out.println(value);
//                // after getting the value we are setting
//                // our value to our text view in below line.
//                //Toast.makeText(MainActivity.this, value.toString(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // calling on cancelled method when we receive
//                // any error or we are not able to get the data.
//                Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
//        // saving whole function to variable
//        noteListener = noteRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//                if(error != null)
//                {
//                    Toast.makeText(MainActivity.this, "Error in Loading", Toast.LENGTH_SHORT).show();
//                    Log.d(TAG+" data On Start",error.toString());
//                    return;
//                }
//
//                if(documentSnapshot.exists())
//                {
//                    String title = documentSnapshot.getString(key_title);
//                    String des = documentSnapshot.getString(key_des);
//                    viewData.setText("Title: "+title+"\n"+"Des : "+des);
//                    Log.d(TAG+" data","Found Data");
//                }else{
//                    Toast.makeText(MainActivity.this, "not Exist", Toast.LENGTH_SHORT).show();
//                    Log.d(TAG+" Data","Not Exist");
//                }
//            }
//        });
        // using this to attach listen to this acticity and destroy it automatically
        // for one document
//        noteRef.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//                if(error != null)
//                {
//                    Toast.makeText(MainActivity.this, "Error in Loading", Toast.LENGTH_SHORT).show();
//                    Log.d(TAG+" data On Start",error.toString());
//                    return;
//                }
//
//                if(documentSnapshot.exists())
//                {
////                    String title = documentSnapshot.getString(key_title);
////                    String des = documentSnapshot.getString(key_des);
////                    viewData.setText("Title: "+title+"\n"+"Des : "+des);
//                    Note note=documentSnapshot.toObject(Note.class);
//                    viewData.setText("Title: "+note.getTitle()+"\n"+"Des : "+note.getDescription());
//                    Log.d(TAG+" data","Found Data");
//                }else{
//                    //needed when no document exist
//                    viewData.setText("");
//                    Toast.makeText(MainActivity.this, "not Exist", Toast.LENGTH_SHORT).show();
//                    Log.d(TAG+" Data","Not Exist");
//                }
//            }
//        });
        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException error) {
                if(error!=null)
                {
                    return;
                }
                String data="";
                for(QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots)
                {
                    Note note = documentSnapshot.toObject(Note.class);
                    note.setDocumentId(documentSnapshot.getId());
                    data+=note.toString()+"\n\n";
                }
                viewData.setText(data);

            }
        });
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        noteListener.remove(); //destroy noteListener when app goes to background.
//    }

//    public void saveNote(View v)
//    {
//        String title = editTextTitle.getText().toString();
//        String des =editTextDes.getText().toString();
//
////        //by hash maps
////        Map<String,Object> note = new HashMap<>();
////        note.put(key_title,title);
////        note.put(key_des,des);
//
//        //by custom java objects
//        Note note=new Note(title,des);
//        Log.d(TAG+" Note ",note.toString());
//
//        noteRef.set(note)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Toast.makeText(MainActivity.this, "Note Saved", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivity.this, "Error in Saving!", Toast.LENGTH_SHORT).show();
//                        Log.d(TAG,e.toString());
//                    }
//                });
//    }

    public void addNote(View v)
    {
        String title = editTextTitle.getText().toString();
        String des =editTextDes.getText().toString();
        if(editTextPriority.length()==0)
            editTextPriority.setText("0");
        int priority = Integer.parseInt(editTextPriority.getText().toString());

//        //by hash maps
//        Map<String,Object> note = new HashMap<>();
//        note.put(key_title,title);
//        note.put(key_des,des);

        //by custom java objects
        Note note=new Note(title,des,priority);
        Log.d(TAG+" Note ",note.toString());

        notebookRef.add(note).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(MainActivity.this, "Note Added", Toast.LENGTH_SHORT).show();
                Log.d(TAG+" Note Status","Added");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                Log.d(TAG+" Note Status","Not Added");
            }
        });
    }
//    public void loadNote(View v)
//    {
//        noteRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if(documentSnapshot.exists())
//                {
////                    // manually getting data
////                    String title = documentSnapshot.getString(key_title);
////                    String des = documentSnapshot.getString(key_des);
//                    //get by java class
//                    Note note=documentSnapshot.toObject(Note.class);
//                    viewData.setText("Title: "+note.getTitle()+"\n"+"Des : "+note.getDescription());
//                    Log.d(TAG+" data","Found Data");
//                }else{
//                    Toast.makeText(MainActivity.this, "not Exist", Toast.LENGTH_SHORT).show();
//                    Log.d(TAG+" Data","Not Exist");
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
//                Log.d(TAG+" Data",e.toString());
//            }
//        });
//    }
    public void loadNotesAll(View v) {
        notebookRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String data = "";
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Note note = documentSnapshot.toObject(Note.class);
                    note.setDocumentId(documentSnapshot.getId());
                    data += note.toString() + "\n\n";
                }
                viewData.setText(data);
            }
        });
    }
    public void loadNotesWithQuery(View v) {
        notebookRef.whereGreaterThanOrEqualTo("priority", 2)
                .orderBy("priority", Query.Direction.DESCENDING) //used when getting multiple results
                .limit(2) //top 2 results
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = "";
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Note note = documentSnapshot.toObject(Note.class);
                            note.setDocumentId(documentSnapshot.getId());
                            data += note.toString() + "\n\n";
                        }
                        viewData.setText(data);
                    }
                });
    }
//    public void updateDescription(View v)
//    {
//        String des = editTextDes.getText().toString();
//        Map<String,Object> note = new HashMap<>();
//        note.put(key_des,des);
//        //following method also creates new document/record if it does not exist
//        // so it is not preferable as we have to only update existing record.
//        //noteRef.set(note, SetOptions.merge());
//
//        //this method will update if document exists,
//        // we can also pass key value pair to be updated
//        noteRef.update(note);
//        //noteRef.update(key_des,des);
//    }
//    public void deleteDescription(View v){
////        Map<String,Object> note =new HashMap<>();
////        note.put(key_des, FieldValue.delete());
////        noteRef.update(note);
//        //Directly remove desccription value, can be done in one line
//        noteRef.update(key_des,FieldValue.delete());
//    }
//
//    public void deleteNote(View v){
//        noteRef.delete();
//    }
}