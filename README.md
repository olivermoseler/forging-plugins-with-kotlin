# forging-plugins-with-kotlin

Supplemental code to lecture: Be(come) the Smith of Your Tools - Forging Plugins with Kotlin

Held as a guest lecture at the <a href="https://www.se.uni-bayreuth.de/en/index.html" target="_blank">Software
Engineering Group</a> under the direction of <a href="https://empirical-software.engineering/" target="_blank">Prof. Dr.
Sebastian Baltes</a> at the
University of Bayreuth on December 18, 2024.

With the support of <a href="https://itestra.com" target="_blank">itestra GmbH</a>.

Plugin idea inspired by: https://www.baeldung.com/intellij-idea-plugins-gradle, last visited: December, 18th 2024

# Branches

- *simple-action*: A regular simple action is implemented and registered to achieve the required functionality.
- *service-with-coroutine*: The actual logic is moved to a corresponding service that uses a coroutine to implement the
  required functionality. See the comments for experimentation with delays and their effect on the UI behavior.

