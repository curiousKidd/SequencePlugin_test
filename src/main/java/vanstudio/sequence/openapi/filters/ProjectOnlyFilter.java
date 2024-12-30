package vanstudio.sequence.openapi.filters;

import com.intellij.psi.PsiElement;
import vanstudio.sequence.util.MyPsiUtil;

import java.util.Objects;

/**
 * Only project class/interface should be included.
 */
public class ProjectOnlyFilter implements MethodFilter {
    private final boolean _projectClassOnly;

    public ProjectOnlyFilter(boolean projectClassOnly) {
        _projectClassOnly = projectClassOnly;
    }

    public boolean allow(PsiElement psiElement) {
        if (_projectClassOnly && isInProject(psiElement)) {
            return false; // 프로젝트 외부의 클래스는 허용하지 않음
        }
        return true; // 허용
    }

    private boolean isInProject(PsiElement psiElement) {
        return MyPsiUtil.isInJarFileSystem(psiElement) || MyPsiUtil.isInClassFile(psiElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectOnlyFilter)) return false;
        ProjectOnlyFilter that = (ProjectOnlyFilter) o;
        return _projectClassOnly == that._projectClassOnly;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(_projectClassOnly);
    }
}

