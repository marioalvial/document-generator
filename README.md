# Document Generator

Generator of CPF and CNPJ

## Installing

If you are working with a maven project you cand add JitPack repository and add project dependecy:

```
<dependecies>        
  <dependency>
    <groupId>com.github.ertyui</groupId>
    <artifactId>document-generator</artifactId>
    <version>1.0-RELEASE</version>
  </dependency>
</dependencies>

<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

```

Or download the jar file at branch "jar-branch" and import in your Java project

## Examples

```
    public static void main(String[] args) {
      DocumentGenerator cpfGenerator = new CPFGenerator();
      DocumentGenerator cnpjGenerator = new CNPJGenerator();

      System.out.println(cpfGenerator.generate());
      System.out.println(cpfGenerator.generateFormatted());
      System.out.println(cnpjGenerator.generate());
      System.out.println(cnpjGenerator.generateFormatted(
    }

```
Output:

```
48276698050
689.904.234-73
20823015951226
62.358.957/8679-47
```
