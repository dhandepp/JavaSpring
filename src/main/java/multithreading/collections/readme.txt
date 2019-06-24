- CopyOnWriteArrayList, CopyOnWriteArraySet, creates a copy whenever modified, ideal for large read and small write operations
- Concurrent Collections, ConcurrentHashMap, no copy is created, may see problems with iterator
                          ■ ConcurrentLinkedDeque
                          ■ ConcurrentLinkedQueue
                          ■ ConcurrentSkipListMap
                          ■ ConcurrentSkipListSet

- Blocking Queues ■ ArrayBlockingQueue      , blocks
                  ■ LinkedBlockingDeque
                  ■ LinkedBlockingQueue
                  ■ PriorityBlockingQueue
                  ■ DelayQueue
                  ■ LinkedTransferQueue
                  ■ SynchronousQueue

