package SinglyLinkedList;

public class QNX {

	public static void main(String[] args) {
		

	}

}

//Perfect — now I’ll give you **FULL EXAM PACKAGE** for each experiment:
//
//👉 **Aim + Concept + Key Logic + Code (short + memorizable)**
//👉 This is **exactly what you write in exam**
//
//---
//
//# 🔥 EXP 1 — fork()
//
//### ✅ Aim
//
//To create a child process and demonstrate parent–child communication.
//
//### 🧠 Concept
//
//`fork()` creates a child → both run → child sends data → parent reads using pipe.
//
//### 🔑 Key Logic
//
//fork → child writes → parent waits → parent reads
//
//### 💻 Code
//
//```c
//#include <stdio.h>
//#include <unistd.h>
//#include <sys/wait.h>
//
//int main() {
//    int fd[2]; pipe(fd);
//    pid_t pid = fork();
//
//    if(pid == 0) {
//        write(fd[1], "Hello", 6);
//    } else {
//        char buf[100];
//        wait(NULL);
//        read(fd[0], buf, sizeof(buf));
//        printf("%s", buf);
//    }
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 2 — pthread
//
//### ✅ Aim
//
//To create and synchronize threads using pthreads.
//
//### 🧠 Concept
//
//Multiple threads run concurrently → main waits using join.
//
//### 🔑 Key Logic
//
//create → run → join
//
//### 💻 Code
//
//```c
//#include <stdio.h>
//#include <pthread.h>
//
//void* func(void* arg) {
//    printf("Thread\n");
//    return NULL;
//}
//
//int main() {
//    pthread_t t;
//    pthread_create(&t, NULL, func, NULL);
//    pthread_join(t, NULL);
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 3 — Mutex
//
//### ✅ Aim
//
//To prevent race condition using mutex.
//
//### 🧠 Concept
//
//Only one thread accesses shared data at a time.
//
//### 🔑 Key Logic
//
//lock → update → unlock
//
//### 💻 Code
//
//```c
//#include <stdio.h>
//#include <pthread.h>
//
//int x = 0;
//pthread_mutex_t m;
//
//void* func(void* arg) {
//    pthread_mutex_lock(&m);
//    x++;
//    pthread_mutex_unlock(&m);
//    return NULL;
//}
//
//int main() {
//    pthread_t t1, t2;
//    pthread_mutex_init(&m, NULL);
//    pthread_create(&t1, NULL, func, NULL);
//    pthread_create(&t2, NULL, func, NULL);
//    pthread_join(t1, NULL);
//    pthread_join(t2, NULL);
//    printf("%d", x);
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 4 — Scheduling
//
//### ✅ Aim
//
//To study thread scheduling policies.
//
//### 🧠 Concept
//
//Different priorities → FIFO > RR > OTHER.
//
//### 🔑 Key Logic
//
//set policy → create threads → observe order
//
//### 💻 Code
//
//```c
//#include <stdio.h>
//#include <pthread.h>
//#include <sched.h>
//
//void* func(void* arg) {
//    printf("Thread\n");
//    return NULL;
//}
//
//int main() {
//    pthread_t t;
//    pthread_attr_t a;
//    struct sched_param p;
//
//    pthread_attr_init(&a);
//    pthread_attr_setschedpolicy(&a, SCHED_FIFO);
//    p.sched_priority = 10;
//    pthread_attr_setschedparam(&a, &p);
//
//    pthread_create(&t, &a, func, NULL);
//    pthread_join(t, NULL);
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 5 — Message Passing
//
//### ✅ Aim
//
//To implement IPC using Send–Receive–Reply.
//
//### 🧠 Concept
//
//Client sends → server receives → server replies.
//
//### 🔑 Key Logic
//
//send → receive → reply
//
//### 💻 Code (simplified)
//
//```c
//#include <stdio.h>
//#include <sys/neutrino.h>
//
//int main() {
//    int chid = ChannelCreate(0);
//    int rcvid;
//    char msg[100] = "Hello";
//
//    rcvid = MsgReceive(chid, msg, sizeof(msg), NULL);
//    MsgReply(rcvid, 0, "Reply", 6);
//
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 6 — Pulse
//
//### ✅ Aim
//
//To demonstrate asynchronous communication using pulses.
//
//### 🧠 Concept
//
//Pulse = non-blocking signal.
//
//### 🔑 Key Logic
//
//send pulse → receive pulse
//
//### 💻 Code
//
//```c
//#include <stdio.h>
//#include <sys/neutrino.h>
//
//int main() {
//    int chid = ChannelCreate(0);
//    struct _pulse p;
//
//    MsgReceive(chid, &p, sizeof(p), NULL);
//    printf("Pulse received");
//
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 7 — Shared Memory
//
//### ✅ Aim
//
//To share data between processes using shared memory.
//
//### 🧠 Concept
//
//Same memory used by multiple processes.
//
//### 🔑 Key Logic
//
//create → map → read/write
//
//### 💻 Code
//
//```c
//#include <stdio.h>
//#include <sys/mman.h>
//#include <fcntl.h>
//
//int main() {
//    int fd = shm_open("x", O_CREAT|O_RDWR, 0666);
//    ftruncate(fd, 1024);
//    char* ptr = mmap(0, 1024, PROT_WRITE, MAP_SHARED, fd, 0);
//
//    sprintf(ptr, "Hello");
//    printf("%s", ptr);
//
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 8 — Interrupt
//
//### ✅ Aim
//
//To handle interrupts.
//
//### 🧠 Concept
//
//Interrupt occurs → handled → count increases.
//
//### 🔑 Key Logic
//
//attach → wait → handle
//
//### 💻 Code
//
//```c
//#include <stdio.h>
//#include <sys/neutrino.h>
//
//int main() {
//    int id = InterruptAttachThread(1, 0);
//    while(1) {
//        InterruptWait(0, NULL);
//        printf("Interrupt\n");
//    }
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 9 — I/O Port
//
//### ✅ Aim
//
//To perform hardware I/O operations.
//
//### 🧠 Concept
//
//Direct read/write to port.
//
//### 🔑 Key Logic
//
//enable → write → read
//
//### 💻 Code
//
//```c
//#include <stdio.h>
//#include <sys/neutrino.h>
//#include <hw/inout.h>
//
//int main() {
//    ThreadCtl(_NTO_TCTL_IO, NULL);
//    out8(0x378, 0xAA);
//    printf("%X", in8(0x378));
//    return 0;
//}
//```
//
//---
//
//# 🔥 EXP 10 — Resource Manager
//
//### ✅ Aim
//
//To implement a resource manager.
//
//### 🧠 Concept
//
//Everything is a file.
//
//### 🔑 Key Logic
//
//attach → read/write
//
//### 💻 Code (minimal)
//
//```c
//#include <stdio.h>
//#include <sys/dispatch.h>
//
//int main() {
//    dispatch_t *d = dispatch_create();
//    resmgr_attach(d, NULL, "/dev/example", 0, 0, NULL, NULL, NULL);
//    while(1) dispatch_block(NULL);
//    return 0;
//}
//```
//
//---
//
//# ⚡ FINAL MEMORY TRICK
//
//👉 Remember each experiment in **one line**:
//
//* fork → process + pipe
//* thread → create + join
//* mutex → lock/unlock
//* sched → FIFO > RR
//* msg → send/receive
//* pulse → signal
//* shm → shared memory
//* interrupt → wait/handle
//* io → in/out
//* resmgr → file

