package com.example.mindtechapplication

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class ExampleWorkerClass(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    val TAG = ExampleWorkerClass::class.java.simpleName

    override fun doWork(): Result {
        /*object : CountDownTimer((30 * 1000), 1000) {
            override fun onTick(p0: Long) {
                for (i in 0..1000)
                    Log.e("TAG", "onick a $i")
            }

            override fun onFinish() {
                Log.e(TAG, "onFinish: " )
            }
        }*/
        val runnable = Runnable {
            for (i in 0..1000) {
                Log.e("TAG", "onick a $i")
                Thread.sleep(1000)
            }
        }
        Thread(runnable).start()
        /*Handler(Looper.getMainLooper()).post( Runnable() {
            @Override
            public void run() {

            }
        });*/
        return Result.success()
    }
}