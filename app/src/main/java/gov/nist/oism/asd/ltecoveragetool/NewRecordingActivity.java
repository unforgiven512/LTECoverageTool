/*
 * This software was developed by employees of the National Institute of Standards and Technology (NIST), an agency of the Federal Government
 * and is being made available as a public service. Pursuant to title 17 United States Code Section 105, works of NIST employees are not
 * subject to copyright protection in the United States.  This software may be subject to foreign copyright.  Permission in the United States
 * and in foreign countries, to the extent that NIST may hold copyright, to use, copy, modify, create derivative works, and distribute
 * this software and its documentation without fee is hereby granted on a non-exclusive basis, provided that this notice and disclaimer of
 * warranty appears in all copies.
 *
 * THE SOFTWARE IS PROVIDED 'AS IS' WITHOUT ANY WARRANTY OF ANY KIND, EITHER EXPRESSED, IMPLIED, OR STATUTORY, INCLUDING, BUT NOT LIMITED TO,
 * ANY WARRANTY THAT THE SOFTWARE WILL CONFORM TO SPECIFICATIONS, ANY IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 * AND FREEDOM FROM INFRINGEMENT, AND ANY WARRANTY THAT THE DOCUMENTATION WILL CONFORM TO THE SOFTWARE, OR ANY WARRANTY THAT THE SOFTWARE WILL
 * BE ERROR FREE.  IN NO EVENT SHALL NIST BE LIABLE FOR ANY DAMAGES, INCLUDING, BUT NOT LIMITED TO, DIRECT, INDIRECT, SPECIAL OR CONSEQUENTIAL
 * DAMAGES, ARISING OUT OF, RESULTING FROM, OR IN ANY WAY CONNECTED WITH THIS SOFTWARE, WHETHER OR NOT BASED UPON WARRANTY, CONTRACT, TORT, OR OTHERWISE,
 * WHETHER OR NOT INJURY WAS SUSTAINED BY PERSONS OR PROPERTY OR OTHERWISE, AND WHETHER OR NOT LOSS WAS SUSTAINED FROM, OR AROSE OUT OF THE RESULTS OF,
 * OR USE OF, THE SOFTWARE OR SERVICES PROVIDED HEREUNDER.
 */
package gov.nist.oism.asd.ltecoveragetool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import gov.nist.oism.asd.ltecoveragetool.util.LteLog;

public class NewRecordingActivity extends AppCompatActivity {

    private static final String TAG = NewRecordingActivity.class.getSimpleName();
    public static final String OFFSET_KEY = "offset_key";

    private EditText mOffsetUi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recording);

        mOffsetUi = findViewById(R.id.activity_new_recording_offset_ui);
        mOffsetUi.setText(Double.toString(0.0));
    }

    public void newRecordingButtonClicked(View view) {
        Intent intent = new Intent(this, RecordActivity.class);
        double offset = 0.0;
        try {
            offset = Double.parseDouble(mOffsetUi.getText().toString().trim());
        }
        catch (Exception caught) {
            LteLog.e(TAG, caught.getMessage(), caught);
        }
        intent.putExtra(OFFSET_KEY, offset);
        startActivity(intent);
    }
}
