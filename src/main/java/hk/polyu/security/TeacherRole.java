package hk.polyu.security;

import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "Teacher", code = TeacherRole.CODE)
public interface TeacherRole {
    String CODE = "teacher";
}