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
        Generator cpf = new CPFGenerator(false);
        Generator cnpj = new CNPJGenerator(false);
        Generator cpfFormatted = new CPFGenerator(true);
        Generator cnpjFormatted = new CNPJGenerator(true);

        System.out.println(cpf.generate());
        System.out.println(cnpj.generate());
        System.out.println(cpfFormatted.generate());
        System.out.println(cnpjFormatted.generate());
    }

```
Output:

```
17970388930
69273015977174
381.204.310-65
01.678.735/2432-04

```
