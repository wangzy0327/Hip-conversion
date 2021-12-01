package com.ncic.pattern;

public enum KPattern {

    KPATTERN1("hipLaunchKernelGGL\\((\\w+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*0\\s*,\\s*0\\s*,\\s*"),
    KPATTERN2("hipLaunchKernelGGL\\((\\w+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*0\\s*,\\s*0\\s*\\);"),
    KPATTERN3("hipLaunchKernelGGL\\(HIP_KERNEL_NAME\\(\\s*(\\w+)\\s*<\\s*(\\w+)\\s*>\\s*\\)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*0\\s*,\\s*0\\s*,\\s*"),
    KPATTERN4("hipLaunchKernelGGL\\(HIP_KERNEL_NAME\\(\\s*(\\w+)\\s*<\\s*(\\w+)\\s*>\\s*\\)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*0\\s*,\\s*0\\s*\\);"),
    KPATTERN5("hipLaunchKernelGGL\\((\\w+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*(\\w+)\\s*,\\s*0\\s*,\\s*"),
    KPATTERN6("hipLaunchKernelGGL\\((\\w+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*(\\w+)\\s*,\\s*0\\s*\\);"),
    KPATTERN7("hipLaunchKernelGGL\\(HIP_KERNEL_NAME\\(\\s*(\\w+)\\s*<\\s*(\\w+)\\s*>\\s*\\)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*0\\s*,\\s*"),
    KPATTERN8("hipLaunchKernelGGL\\(HIP_KERNEL_NAME\\(\\s*(\\w+)\\s*<\\s*(\\w+)\\s*>\\s*\\)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*0\\s*\\);"),
    KPATTERN9("hipLaunchKernelGGL\\((\\w+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*"),
    KPATTERN10("hipLaunchKernelGGL\\((\\w+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*([\\w|\\(|\\)]+)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*\\);"),
    KPATTERN11("hipLaunchKernelGGL\\(HIP_KERNEL_NAME\\(\\s*(\\w+)\\s*<\\s*(\\w+)\\s*>\\s*\\)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*"),
    KPATTERN12("hipLaunchKernelGGL\\(HIP_KERNEL_NAME\\(\\s*(\\w+)\\s*<\\s*(\\w+)\\s*>\\s*\\)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*,\\s*(\\w+)\\s*\\);");

    private String value;

    KPattern(String keyword){
        this.value = keyword;
    }

    public String getValue() {
        return value;
    }
}
