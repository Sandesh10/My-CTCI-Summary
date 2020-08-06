Design questions is much more about the process than the ultimate design.


Concepts:

HORIZONTAL vs VERTICAL SCALING:
Vertical scaling is generally easier than horizontal scaling, but it's limited. You can only add so much memory or disk space.

- Vertical Scaling: 
increasing the resources of a specific node. Eg: you might add additional memory to a server to improve its ability to handle load changes.

- Horizontal Scaling:
increasing the number of nodes. For eg: you might add additional servers, thus decreasing the load of any one server.

LOAD BALANCER
Typically, some frontend parts of a scalable website will be thrown behind a load balance. This allows a system to distribute the load evenly so that one server doesn't crash and take down the whole system. To do so, you have to build out a network of cloned servers that all have essentially the same code and access to the same data.

DATABASE DENORMALIZATION and NOSQL
Joins in a relational database such as SQL can get very slow as the system grows bigger. For this reason, you would generally avoid them.

Denormalization is one part of this. Denormalizing means adding redundant information into a database to speed up reads. For example, imagine a database describing projects and tasks (where a project can have multiple tasks.) You might need to get the project name and the task information. Rather than doing a join across these tables, you can store the project name within the task table.
Or you can go with a NoSQL database. A NoSQL database does not support joins and might structure data in a different way. It is designed to scale better.

Database Partitioning (Sharding)
Sharding means splitting the data across multiple machines while ensuring you have a way of figuring out which data is on which machine.

A few common ways of partitioning include:

- Vertical Partitioning: This is basically partitioning by feature. For example, if you were building a social network, you might have one partition for tables related to profiles, another one for messages and so on. One drawback of this is that if one of these tables get very large, you might need to repartition that database.

- Key-Based (or Hash-Based) Partitioning: This uses some part of the data (for example an ID) to partition it. A very simple way to do this is to allocate N servers and put the data on mod(key,n). One issue with this is that the number of servers you have is effectively fixed. Adding additional servers means reallocating all the data -  a very expensive task.

Directory-Based Partitioning: In this scheme, you maintain a lookup table for where the data can be found. This makes it relatively easy to add additional servers, but it comes with two drawbacks.
First, the lookup table can be a single point of failure. Second, constantly accessing this table impacts performance.

Many architectures actually end up using multiple partitioning schemes.

Caching:
An in-memory cache can deliver very rapid results. It is a simple key-value pairing and typically sits between your application layer and your data store.
When an application requests a piece of information, it first tries the cache. If the cache does not contain the key, it will then look up the data in the data store.
When you cache, you might cache a query and its results directly. Or, alternatively, you can cache the specific object(for eg, a rendered version of a part of the website, or a lost of the most recent blog posts.)

Asychronous Processing & Queues
Slow operations should ideally be done asnchronously. Otherwise, a user might get stuck waiting for a process to complete.
IN some cases, we can do this in advance (i.e. we can pre-process). For eg: we might have a queue if jobs to be done that update some part of the website. If we were running a forum, one of these jobs might be to re-render a page that lists the most popular posts and the number of comments. That list might end up being slightly out of data, but that's perhaps okay. It's better than a user stuck waiting on the website to load simply because someone added a new comment and invalidated the cached version of this page.

In other cases, we might tell the user to wait and notify them when the process is done. You've probably seen this on websites before. Perhaps you enabled some new part of a website and it says it needs a few minutes to import your data, but you'll get a notification when it's done.


NETWORKING METRICS

Bandwidth: maxm amount of data that can be transferred in a unit of time. (eg: bits per sec)

Throughput: Actual amount of data that is transferred.

Latency: Delay between sending and receiving.

Availability: percentage of time the system is operational.
Reliability: probability that the system is operational for a certain unit of time.

For Read Heavy application - cache
For write heavy application - queue up the writes


MAP-REDUCE
- used to process large amount of data.
- allows us to do a lot of processing in parallel, which makes processing huge amounts of data more scalable.

A mapReduce program requires you to write a Map step and a Reduce step. The rest is handled by the system.
- Map takes in some data and emits a <key, value> pair.
- Reduce takes a key and a set of associated values and "reduces" them in some way, emitting a new key and value. The results of this might be fed back into the Reduce program for more reducing.




Handling Design Questions:
- Communicate
- Go broad first: Don't dive straight into algorithm part or get excessively focused on one part.
- Use the whiteboard: use whiteboard since the beginning and use it to draw a picture of what you're proposing.
- Acknowlwdge interviewer concerns: Acknowledge the issues your interviewer points out and make changes accordingly.
- Be careful about assumptions:
- State your assumptions explicitly: state your assumptions clearly. This allows your interviewer to correct you if you're mistaken.
- Estimate when necessary
- Drive: Drive through your approach. Ask questions. Be open about tradeoffs. Continue to make improvements.
---------------------------------------------
Algorithm that Scale: Step-By-Step

1. Ask Questions:
- Ask questionst to understand exactly what the problem is.

2. Make Believe
- Pretend that the data can all fit on one machine and there are no memory limitations.

3. Get Real
- How much data can you fit on one machine and what problems will occur when you split up the data.
- Common problems include figuring out how to logically divide the data up and how one machine would identify where to look up a different piece of data.

4. Solve Problem:
- 

----------------------------------------------
System Design for TinyURL

Questions to Ask:
- will people be able to specify their own short URL or it will be auto-generated.
- Do we need to keep track of any stats on the clicks?
- Should the URL stay active forever or do they timeout?


Major Features:
- Shortening a URL to a TinyURL
- Analytics for a URL
- Retrieving the URL associated with a TinyURL
- User accounts and link management.


Reasonable Assumptions:
Eg: system only needs to process 100 users per day or assume you have infinite memory available.

Draw Major Components:
Eg: frontend server/servers that pull data from the backend's data store. You might have another set of servers that crawl the internet for some data, and another set that process analytics.

Identify Key Issues (Bottlenecks / major challenges)
Eg: Some urls may be infrequently accessed, others can suddenly peak. You don't necessarily want to constantly hit the database.

Redesign for Key Issues (if interviewer provide some guidance)
Eg: using a cache.


