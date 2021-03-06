/*
 * Kimios - Document Management System Software
 * Copyright (C) 2012-2013  DevLib'
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kimios.kernel.dms;

public class FactoryInstantiator
{
    private static FactoryInstantiator instance;

    private FactoryInstantiator()
    {
    }

    synchronized public static FactoryInstantiator getInstance()
    {
        if (instance == null) {
            instance = new FactoryInstantiator();
        }
        return instance;
    }

    DMEntityFactory dmEntityFactory;

    DocumentFactory documentFactory;

    FolderFactory folderFactory;

    DocumentVersionFactory documentVersionFactory;

    DocumentTypeFactory documentTypeFactory;

    WorkspaceFactory workspaceFactory;

    MetaFactory metaFactory;

    MetaFeedFactory metaFeedFactory;

    MetaValueFactory metaValueFactory;

    WorkflowFactory workflowFactory;

    WorkflowStatusFactory workflowStatusFactory;

    EnumerationValueFactory enumerationValueFactory;

    BookmarkFactory bookmarkFactory;

    RecentItemsFactory recentItemFactory;

    LockFactory lockFactory;

    WorkflowStatusManagerFactory workflowStatusManagerFactory;

    DocumentWorkflowStatusFactory documentWorkflowStatusFactory;

    DocumentWorkflowStatusRequestFactory documentWorkflowStatusRequestFactory;

    DocumentCommentFactory documentCommentFactory;

    SymbolicLinkFactory symbolicLinkFactory;

    public DocumentTypeFactory getDocumentTypeFactory()
    {
        return documentTypeFactory;
    }

    public void setDocumentTypeFactory(DocumentTypeFactory documentTypeFactory)
    {
        this.documentTypeFactory = documentTypeFactory;
    }

    public DMEntityFactory getDmEntityFactory()
    {
        return dmEntityFactory;
    }

    public void setDmEntityFactory(DMEntityFactory dmEntityFactory)
    {
        this.dmEntityFactory = dmEntityFactory;
    }

    public DocumentFactory getDocumentFactory()
    {
        return documentFactory;
    }

    public void setDocumentFactory(DocumentFactory documentFactory)
    {
        this.documentFactory = documentFactory;
    }

    public FolderFactory getFolderFactory()
    {
        return folderFactory;
    }

    public void setFolderFactory(FolderFactory folderFactory)
    {
        this.folderFactory = folderFactory;
    }

    public DocumentVersionFactory getDocumentVersionFactory()
    {
        return documentVersionFactory;
    }

    public void setDocumentVersionFactory(
            DocumentVersionFactory documentVersionFactory)
    {
        this.documentVersionFactory = documentVersionFactory;
    }

    public WorkspaceFactory getWorkspaceFactory()
    {
        return workspaceFactory;
    }

    public void setWorkspaceFactory(WorkspaceFactory workspaceFactory)
    {
        this.workspaceFactory = workspaceFactory;
    }

    public MetaFactory getMetaFactory()
    {
        return metaFactory;
    }

    public void setMetaFactory(MetaFactory metaFactory)
    {
        this.metaFactory = metaFactory;
    }

    public MetaFeedFactory getMetaFeedFactory()
    {
        return metaFeedFactory;
    }

    public void setMetaFeedFactory(MetaFeedFactory metaFeedFactory)
    {
        this.metaFeedFactory = metaFeedFactory;
    }

    public MetaValueFactory getMetaValueFactory()
    {
        return metaValueFactory;
    }

    public void setMetaValueFactory(MetaValueFactory metaValueFactory)
    {
        this.metaValueFactory = metaValueFactory;
    }

    public WorkflowFactory getWorkflowFactory()
    {
        return workflowFactory;
    }

    public void setWorkflowFactory(WorkflowFactory workflowFactory)
    {
        this.workflowFactory = workflowFactory;
    }

    public WorkflowStatusFactory getWorkflowStatusFactory()
    {
        return workflowStatusFactory;
    }

    public void setWorkflowStatusFactory(WorkflowStatusFactory workflowStatusFactory)
    {
        this.workflowStatusFactory = workflowStatusFactory;
    }

    public EnumerationValueFactory getEnumerationValueFactory()
    {
        return enumerationValueFactory;
    }

    public void setEnumerationValueFactory(
            EnumerationValueFactory enumerationValueFactory)
    {
        this.enumerationValueFactory = enumerationValueFactory;
    }

    public BookmarkFactory getBookmarkFactory()
    {
        return bookmarkFactory;
    }

    public void setBookmarkFactory(BookmarkFactory bookmarkFactory)
    {
        this.bookmarkFactory = bookmarkFactory;
    }

    public RecentItemsFactory getRecentItemFactory()
    {
        return recentItemFactory;
    }

    public void setRecentItemFactory(RecentItemsFactory recentItemFactory)
    {
        this.recentItemFactory = recentItemFactory;
    }

    public LockFactory getLockFactory()
    {
        return lockFactory;
    }

    public void setLockFactory(LockFactory lockFactory)
    {
        this.lockFactory = lockFactory;
    }

    public WorkflowStatusManagerFactory getWorkflowStatusManagerFactory()
    {
        return workflowStatusManagerFactory;
    }

    public void setWorkflowStatusManagerFactory(
            WorkflowStatusManagerFactory workflowStatusManagerFactory)
    {
        this.workflowStatusManagerFactory = workflowStatusManagerFactory;
    }

    public DocumentWorkflowStatusFactory getDocumentWorkflowStatusFactory()
    {
        return documentWorkflowStatusFactory;
    }

    public void setDocumentWorkflowStatusFactory(
            DocumentWorkflowStatusFactory documentWorkflowStatusFactory)
    {
        this.documentWorkflowStatusFactory = documentWorkflowStatusFactory;
    }

    public DocumentWorkflowStatusRequestFactory getDocumentWorkflowStatusRequestFactory()
    {
        return documentWorkflowStatusRequestFactory;
    }

    public void setDocumentWorkflowStatusRequestFactory(
            DocumentWorkflowStatusRequestFactory documentWorkflowStatusRequestFactory)
    {
        this.documentWorkflowStatusRequestFactory = documentWorkflowStatusRequestFactory;
    }

    public DocumentCommentFactory getDocumentCommentFactory()
    {
        return documentCommentFactory;
    }

    public void setDocumentCommentFactory(
            DocumentCommentFactory documentCommentFactory)
    {
        this.documentCommentFactory = documentCommentFactory;
    }

    public SymbolicLinkFactory getSymbolicLinkFactory()
    {
        return symbolicLinkFactory;
    }

    public void setSymbolicLinkFactory(SymbolicLinkFactory symbolicLinkFactory)
    {
        this.symbolicLinkFactory = symbolicLinkFactory;
    }
}

