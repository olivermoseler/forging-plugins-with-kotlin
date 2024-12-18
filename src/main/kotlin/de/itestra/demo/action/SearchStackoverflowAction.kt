package de.itestra.demo.action

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.service
import de.itestra.demo.service.StackoverflowService

class SearchStackoverflowAction : AnAction() {

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.EDT
    }

    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        val currentCaret = editor?.caretModel?.currentCaret
        val hasSelection = currentCaret?.hasSelection()
        e.presentation.isEnabledAndVisible = hasSelection!!
    }

    override fun actionPerformed(e: AnActionEvent) {
        val psiFile = e.getData(CommonDataKeys.PSI_FILE)
        val editor = e.getData(CommonDataKeys.EDITOR)
        val stackoverflowService = ApplicationManager.getApplication().service<StackoverflowService>()
        stackoverflowService.searchStackoverflow(editor, psiFile)
    }
}