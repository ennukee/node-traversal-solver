# node-traversal-solver

Was designed to help solve **Problem 14.5.3** in *CS250: Introduction to Computation*

Not really designed for public use, but I put it here for archiving purposes.

### Usage

 1. Download Node.scala (optionally main.scala)
 2. Copy the code and `:paste` it into the Scala REPL
 3. Generate your Nodes and Paths as desired (see main.scala for example)
 4. Run `.find_paths(str)` on your start node. This will find paths from your start node to the end node that result in the desired string.
 5. If you're looking for all strings of a certain length (and their paths), use `.find_paths_of_len(int)`
 6. Voila
