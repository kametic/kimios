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
package org.kimios.client.controller;

import org.kimios.client.exception.DMSException;
import org.kimios.client.exception.ExceptionHelper;
import org.kimios.kernel.index.query.model.Criteria;
import org.kimios.kernel.index.query.model.SearchRequest;
import org.kimios.kernel.index.query.model.SearchResponse;
import org.kimios.kernel.ws.pojo.DMEntity;
import org.kimios.kernel.ws.pojo.Document;
import org.kimios.webservices.SearchService;

import java.util.List;

/**
 * SearchController is used to find document or other entity from keywords
 */
public class SearchController
{
    private SearchService client;

    public SearchService getClient()
    {
        return client;
    }

    public void setClient( SearchService client )
    {
        this.client = client;
    }

    /**
     * Make quick search and get documents
     */
    public SearchResponse quickSearch( String sessionId, int dmEntityType, long dmEntityId, String query, int start,
                                       int pageSize, String sort, String sortDir )
        throws Exception
    {
        try
        {
            return client.quickSearch( sessionId, query, dmEntityId, dmEntityType, start, pageSize, sort, sortDir );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }
    }

    /**
     * Make advanced search and get documents
     */
    public List<Document> advancedSearch( String sessionId, String xmlStream, long dmEntityId, int dmEntityType )
        throws Exception
    {
        try
        {
            return client.advancedSearch( sessionId, xmlStream, dmEntityId, dmEntityType );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }
    }

    /**
     * Get path from entity
     */
    public String getPathFromDMEntity( String sessionId, long dmEntityId, int dmEntityType )
        throws Exception, DMSException
    {
        try
        {
            return client.getPathFromDMEntity( sessionId, dmEntityId, dmEntityType );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }
    }

    /**
     * Get entity from path
     */
    public DMEntity getDMEntityFromPath( String sessionId, String path )
        throws Exception, DMSException
    {
        try
        {
            return client.getDMentityFromPath( sessionId, path );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }
    }


    public SearchResponse advancedSearchDocument( String sessionId,
                                                  List<Criteria> criteriaList, int start, int pageSize, String sort,
                                                  String sortDir )
        throws Exception
    {
        try
        {
            return client.advancedSearchDocuments( sessionId, criteriaList, start, pageSize,
                                                   sort, sortDir );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }
    }


    public void saveQuery( String sessionId, Long searchId, String searchName, List<Criteria> criteriaList, String sort,
                           String sortDir )
        throws Exception
    {

        try
        {
            client.saveSearchQuery( sessionId, searchId, searchName, criteriaList, sort, sortDir );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }


    }

    public List<SearchRequest> listQueries( String sessionId )
        throws Exception
    {

        try
        {
            return client.listSearchQueries( sessionId );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }


    }


    public void deleteQuery( String sessionId, Long id )
        throws Exception
    {

        try
        {
            client.deleteSearchQuery( sessionId, id );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }


    }


    public SearchResponse executeSearchQuery( String sessionId, long savedQueryId, int start, int pageSize, String sort,
                                              String sortDir )
        throws Exception
    {
        try
        {
            return client.executeSearchQuery( sessionId, savedQueryId, start, pageSize, sort, sortDir );
        }
        catch ( Exception e )
        {
            throw new ExceptionHelper().convertException( e );
        }
    }
}

