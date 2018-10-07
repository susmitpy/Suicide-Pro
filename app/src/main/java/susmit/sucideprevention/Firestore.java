package susmit.sucideprevention;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Firestore {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference;
    


    public void addData(String name, String contact, String trustedContact) throws GeneralSecurityException {
        collectionReference = db.collection("users");
        Map<String, String> data = new HashMap<>();
        data.put("forName",name);
        data.put("userName", contact);
        data.put("passWord", trustedContact);

        collectionReference.add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.e("fsAddData", "Saved To FS");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("fsAddData", e.toString());
            }
        });
    }






    public void changeData(String forname, String username, String password) throws GeneralSecurityException {

        collectionReference = db.collection("users");
        final Query query = collectionReference.whereEqualTo("forName", forname);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document: task.getResult()){
                        String docId = document.getId();
                        DocumentReference documentReference = db.document("users/" + docId);
                        Map<String, Object> update = new HashMap<String, Object>() {{
                            put("Danger", 1);
                        }
                        };
                        documentReference.update(update);
                    }
                }
            }
        });

    }

    public void delData(String name) throws GeneralSecurityException {
        collectionReference = db.collection("users");
        final Query query = collectionReference.whereEqualTo("Name", name);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot documentSnapshot: task.getResult())
                    {
                        String docId = documentSnapshot.getId();
                        DocumentReference documentReference = FirebaseFirestore.getInstance()
                                                              .collection("users")
                                                              .document(docId);
                        documentReference.delete();
                    }
                }
            }
        });
    }

}


