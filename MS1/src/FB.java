public class FB {

    public void doFB() {
        // TODO fill the bucket with a val++ after on safe space is fully up to date then zero out the variable val and use it for the next bucket.
        int val = 2;
        int[] bucket = new int[]{1,2,3,4};
        String[] A = new String[]{".", ".", ".", ".", ".",};

        for (int i = 0; i < bucket.length; i++)
        bucket[1] += i;
        A[1] = String.valueOf(bucket[1]);
        System.out.println(A[0] + " " + A[1]);
    }

}
