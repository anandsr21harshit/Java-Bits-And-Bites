Two threads, a producer and a consumer share a common fixed-size buffer
as a queue.


The Producer's job is to generate data and put it into the buffer, while the consumer's job
is to remove data from the buffer.

The problem is to make sure that that producer won't producer data if
buffer is full and the consumer won't consumer data if the buffer is empty