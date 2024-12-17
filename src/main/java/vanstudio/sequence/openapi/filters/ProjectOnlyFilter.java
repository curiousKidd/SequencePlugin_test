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

//    public boolean allow(PsiElement psiElement) {
//        if(_projectClassOnly && isInProject(psiElement))
//            return false;
//        return true;
//    }

    public boolean allow(PsiElement psiElement) {
        return (this._projectClassOnly || !MyPsiUtil.isInProject(psiElement));
//        return true;
    }

    private boolean isInProject(PsiElement psiElement) {
        return MyPsiUtil.isInJarFileSystem(psiElement) || MyPsiUtil.isInClassFile(psiElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectOnlyFilter that = (ProjectOnlyFilter) o;
        return _projectClassOnly == that._projectClassOnly;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
