# Hip-conversion

### Tools to translate HIP source code into portable CUDA automatically
## Table of Contents

###  solution
`hip-conversion` is an autogenerated java-based program which heavily uses regular expressions reference on hipify-perl.

**Advantages:**

1. Ease of use.

2. It doesn't check the input source CUDA code for correctness.

3. It doesn't have dependencies on 3rd party tools, including CUDA.

**Disadvantages:**

1. Current disability (and difficulty in implementing) of transforming the following constructs:

    * macros expansion;

    * namespaces:

        - redefines of CUDA entities in user namespaces;

        - using directive;

    * templates (some cases);

    * device/host function calls distinguishing;

    * header files correct injection;

    * complicated argument lists parsing.
2. Difficulties in supporting.

test-files in [here](src/main/conversion-files)

conversion path config in [here](src/main/resources)



In the end, attach [hipify-perl](https://github.com/ROCm-Developer-Tools/HIPIFY) link

