## UnsupportedOperationException

Most of the time we create List in Java using the Arrays.asList().
However, one drawback of using this way to create a list is that some operations will not be supported.

If you check the return type of Arrays.asList(), it is of type List.
Now List is an interface which does not have its own implementation of few operations such as remove(),add() etc.
Hence, if you try to add, remove or perform any other operation which does have its implementation in the List interface
then it will throw UnsupportedOperationException