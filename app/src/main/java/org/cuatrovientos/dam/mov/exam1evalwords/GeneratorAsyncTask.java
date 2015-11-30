package org.cuatrovientos.dam.mov.exam1evalwords;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class GeneratorAsyncTask extends AsyncTask<String,String,Void> {

    // We well keep a reference to our caller activity
    // so we can attach/detach in case of activity is destroyed in a rotation
    private WordsActivity mainActivity;

    /**
     * Default constructor
     * @param mainActivity
     */
    public GeneratorAsyncTask (WordsActivity mainActivity) {
        attach(mainActivity);
    }

    /**
     * sets mainActivity reference
     * @param mainActivity
     */
    public void attach(WordsActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    /**
     * when task is finished this reference is not needed any longer
     */
    public void detach () {
        this.mainActivity = null;
    }

    /**
     * This is called before doInBackground and is a perfect place
     * to prepare the progress Bar.
     */
    @Override
    protected void onPreExecute () {
        Toast.makeText(this.mainActivity, "Starting Async Task", Toast.LENGTH_SHORT).show();
       // this.mainActivity.getProgressBar1().setVisibility(1);
        //this.mainActivity.getResultTextView().setText("");
    }

    /**
     * This is where the task begins and runs
     * String... url declares variable arguments list,
     * and we can get values using indexes: url[0], url[1],...
     * Whenever we consider that we make som progress we can
     * notify through publishProgress()
     */
    @Override
    protected Void doInBackground(String... url) {
        Log.d("URL passed to AsyncTask: " + url[0],"PELLODEBUG");

          try {

        } catch (Exception e) {
            Log.d("PELLODEBUG","Exception processing JSON: " + e.getMessage());
        }
        // With this call we notify to progressUpdate
        Log.d("PELLODEBUG","doInBackbround publishes progress");

        // TODO Auto-generated method stub
        return null;
    }

    /**
     * This method is called when we call this.publishProgress
     * and can be used to update contents,progress bars,... in the Activity
     */
    @Override
    protected void onProgressUpdate(String... item) {
        Log.d( "PELLODEBUG","onProgressUpdate> json data: " + item[0] + " and " + item[1]);
       // this.mainActivity.getResultTextView().append(item[0] + " and " + item[1]+"\n");
    }

    /**
     * called when task is finished.
     */
    @Override
    protected void onPostExecute(Void unused) {
        Toast.makeText(this.mainActivity, "Finished Async Task", Toast.LENGTH_SHORT).show();
        Log.d("PELLODEBUG", "onPostExecute was called: ");
       // this.mainActivity.getProgressBar1().setVisibility(ProgressBar.INVISIBLE);

    }



}