package com.github.samples;

public class Main {
    public static void main(String[] args) {

        new Main().oldFashionedCode();
        new Main().lambdaStyle();
    }

    public void oldFashionedCode() {
        try{
            System.out.println("Try something");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public void lambdaStyle() {

        Try.with(()->{
            System.out.println("Try something");
            throw new Exception();
        }).recover(() -> {
            System.out.println("Exception");
        }).thenAccept(() -> {
            System.out.println("After");
        });

     }

     interface CheckedRunnable {
        void run() throws Exception;
     }

    interface Try{

       Try thenAccept(CheckedRunnable checkedRunnable);
       Try recover(CheckedRunnable checkedRunnable);

        static Try success() {
            return new Success();
        }
        static Try failure() {
            return new Failure();
        }
         static Try with(CheckedRunnable runnable) {
             try{
                 runnable.run();
                 return Try.success();
             } catch (Exception e) {
                return Try.failure();
             }

         }
         class Success implements Try{
             @Override
             public Try recover(CheckedRunnable checkedRunnable) {
                 return this;
             }

             @Override
             public Try thenAccept(CheckedRunnable checkedRunnable) {
                 return Try.with(checkedRunnable);
             }
         }
         class Failure implements  Try{
             private boolean isSuccess = false;

             @Override
             public Try thenAccept(CheckedRunnable checkedRunnable) {
                 return this;
             }

             @Override
             public Try recover(CheckedRunnable checkedRunnable) {
                 return Try.with(checkedRunnable);
             }
         }
    }






}
