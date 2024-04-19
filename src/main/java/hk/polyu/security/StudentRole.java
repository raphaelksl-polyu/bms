package hk.polyu.security;

import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Student", code = StudentRole.CODE)
public interface StudentRole {
    String CODE = "student";
}